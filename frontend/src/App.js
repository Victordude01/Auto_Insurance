import { BrowserRouter as Router, Route, Routes, } from "react-router-dom";
import Navbar from './components/Navbar';
import Home from './components/Home';
import Footer from "./components/Footer";
import PolicyHolderComponent from "./components/PolicyHolderComponent";
import AddPolicyHolder from "./components/AddPolicyHolder";
import EditPolicyHolder from "./components/EditPolicyHolder";


function App() {
  return (
    <div className="app">
      <Router>
        <Navbar/>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/policyholders" element={<PolicyHolderComponent />} />
          <Route path="/policyholders/add-policyholder" element={<AddPolicyHolder />} />
          <Route path="/edit-policyholder/:policyNum" element={<EditPolicyHolder />} />
        </Routes>
        <Footer />
      </Router>
    </div>
  );
}

export default App;
