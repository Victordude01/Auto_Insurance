import React,{useState} from 'react'
import './../styling/form.css'

const AddPolicyHolder = () => {
    const[policyNum,setPolicyNum] = useState('')
    const[name,setName] = useState('')
    const[phone,setPhone] = useState('')
    const[email,setEmail] = useState('')
    const[address,setAddress] = useState('')

    const savePolicyHolder = (e) => {
        e.preventDefault();

        const policyholder = {policyNum,name,phone,email,address}

        console.log(policyholder);
    }

    return (
        <div className="register">
        <div className="register__container">
        <p className="title">Create A New Policy</p>
          <input
            type="text"
            className="register__textBox"
            value={policyNum}
            onChange={(e) => setPolicyNum(e.target.value)}
            placeholder="Policy Number (7 digits)"
          />
            <input
            type="text"
            className="register__textBox"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="Full Name"
          />
              <input
            type="text"
            className="register__textBox"
            value={phone}
            onChange={(e) => setPhone(e.target.value)}
            placeholder="Phone Number"
          />
          <input
            type="text"
            className="register__textBox"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="Email"
          />
          <input
            type="text"
            className="register__textBox"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
            placeholder="Address"
          />
          <button className="register__btn" onClick={(e) => savePolicyHolder(e)}>
            Create
          </button>
  
        </div>
      </div>
    )
}

export default AddPolicyHolder