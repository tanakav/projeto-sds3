import BarChart from "components/BarChart";
import DataTable from "components/DataTable";
import DonutChart from "components/DonutChart";
import Footer from "components/Footer";
import Navbar from "components/Navbar";
import React from "react";

const Dashboard = () => {

    return (
        <>
            <Navbar />
            <div className="container">
                <h1 className="text-primary py-3">Dashboard de Venda</h1>
                <div className="row px-2">
                    <div className="col-sm-6">
                        <h5 className="text-center text-secondary">Taxa de sucesso (%)</h5>
                        <BarChart />
                    </div>
                    <div className="col-sm-6">
                        <h5 className="text-center text-secondary">Todas vendas</h5>
                        <DonutChart />
                    </div>
                </div>
                <div className="py-3">
                    <h2 className="text-primary">
                        Todas vendas
          </h2>
                </div>
                <DataTable />
            </div>
            <Footer />
        </>
    );
}

export default Dashboard;