import axios from 'axios';
import { BASE_URL } from 'components/utils/requests';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';

type ChartData = {
    "labels": string[],
    "series": number[]
}

const DonutChart = () => {
    let chartData: ChartData = {
        labels: [],
        series: []
    }

    // const mockData = {
    //     series: [477138, 499928, 444867, 220426, 473088],
    //     labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    // }

    axios.get(`${BASE_URL}/sales/total-by-seller`)
        .then((response) => {
            const data = response.data as SaleSum[];
            const dataLabels = data.map(sellerData => sellerData.sellerName);
            const dataSeries = data.map(sellerData => sellerData.sum);
            chartData = {
                labels : dataLabels,
                series: dataSeries
            }
            console.log(chartData);
        });

    const options = {
        legend: {
            show: true
        }
    }
    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;