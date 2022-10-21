import { BrowserRouter as Router, Route, Routes, } from "react-router-dom";
import Navbar from './components/Navbar';
import Home from './components/Home';
import Footer from "./components/Footer";
import PolicyHolderComponent from "./components/PolicyHolderComponent";
import AddPolicyHolder from "./components/AddPolicyHolder";


function App() {
  return (
    <div className="app">
      <Router>
        <Navbar/>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/policyholders" element={<PolicyHolderComponent />} />
          <Route path="/add-policyholder" element={<AddPolicyHolder />} />

        </Routes>
        <Footer />
      </Router>
    </div>
  );
}

export default App;
