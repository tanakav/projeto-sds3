import Footer from "components/Footer";
import Navbar from "components/Navbar";
import DataTable from "components/DataTable";

function App() {
  return (
    <>
      <Navbar />
      <div className="container">
        <h1>Hello World</h1>
        <DataTable />
      </div>
      <Footer />
    </>
  );
}

export default App;
