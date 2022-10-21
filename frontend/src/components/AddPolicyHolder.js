import React,{useState} from 'react'
import PolicyHolderService from '../services/PolicyHolderService'
import './../styling/form.css'
import { Link,useNavigate} from "react-router-dom"



const AddPolicyHolder = () => {
    const[policyNum,setPolicyNum] = useState('')
    const[name,setName] = useState('')
    const[phoneNumber,setPhoneNumber] = useState('')
    const[email,setEmail] = useState('')
    const[address,setAddress] = useState('')
    const nav = useNavigate();

    const savePolicyHolder = (e) => {
        e.preventDefault();

        if(!policyNum || !name || !phoneNumber || !email || !address)alert("Please fill in all the information");
        else{
          const policyholder = {policyNum,name,phoneNumber,email,address}
          console.log(policyholder)

          PolicyHolderService.createPolicyHolder(policyholder).then((response) =>{
              console.log(response.data)
          }).catch(error =>{
              console.log(error)
          })
          nav('/policyholders');
        }

    }

    return (
        <div className="form">
        <div>
        <p className="title">Create A New Policy</p>
          <input
            type="number"
            className="textBox"
            value={policyNum}
            onChange={(e) => setPolicyNum(e.target.value)}
            placeholder="Policy Number (7 digits)"
          />
            <input
            type="text"
            className="textBox"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="Full Name"
          />
              <input
            type="text"
            className="textBox"
            value={phoneNumber}
            onChange={(e) => setPhoneNumber(e.target.value)}
            placeholder="Phone Number"
          />
          <input
            type="text"
            className="textBox"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="Email"
          />
          <input
            type="text"
            className="textBox"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
            placeholder="Address"
          />
          <div className='bt-1'>
            <button className="create" onClick={(e) => savePolicyHolder(e)}>
            Create
            </button>
            <Link to ="/policyholders" className="cancel">Cancel</Link>
          </div>
        </div>
      </div>
    )
}

export default AddPolicyHolder