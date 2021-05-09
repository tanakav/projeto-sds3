import axios from 'axios';
import { round } from 'components/utils/format';
import { BASE_URL } from 'components/utils/requests';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSuccess } from 'types/sale';

type SeriesData = {
    "name": string,
    "data": number[]
}

type ChartData = {
    "labels": {
        categories: string[];
    },
    "series": SeriesData[]
}

const BarChart = () => {
    const [chartData, setChartData] = useState<ChartData>({
        labels: {
            categories: []
        },
        series: [
            {
                name: "",
                data: []
            }
        ]
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/success-by-seller`)
        .then((response) => {
            const data = response.data as SaleSuccess[];
            const dataLabels = data.map(sellerData => sellerData.sellerName);
            const dataSeries = data.map(sellerData => round((sellerData.deals/ sellerData.visited) * 100, 1));

            setChartData({
                labels: {
                    categories: dataLabels
                },
                series: [
                    {
                        name: "% Success",
                        data: dataSeries
                    }
                ]
            });
        })
    }, []);

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    return (
        <Chart
            options={{ ...options, xaxis: chartData.labels }}
            series={chartData.series}
            type="bar"
            height="240"
        />
    );
}

export default BarChart;

