import React,{useState,useEffect} from 'react'
import PolicyHolderService from '../services/PolicyHolderService'
import {Link} from "react-router-dom"

const PolicyHolderComponent = () => {
    const[policyholders,setPolicyHolders] = useState([])

    useEffect(() => {
        getAllPolicyHolders();
    },[])

    const getAllPolicyHolders = () => {
        PolicyHolderService.getAllPolicyHolders().then((response) => {
            setPolicyHolders(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
    }

    const deletePolicyHolder = (policyNum) =>{
        PolicyHolderService.deletePolicyHolder(policyNum).then((reponse) =>{
            getAllPolicyHolders();
        }).catch(error =>{
            console.log(error);
        })
    }

    return (
        <div className='container'>
            <div className='top'>
                <Link to = "add-policyholder" className = "add-btn">Create New Policy</Link>
            </div>
            <h2>Current Policy Holders</h2>
            <div className='ph'>
                <table>
                    <thead>
                        <th>Policy Number</th>
                        <th>Full Name</th>
                        <th>Phone Number</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Actions</th>
                    </thead>
                    <tbody>{
                            policyholders.map(
                                policyholder =>
                                <tr key = {policyholder.policyNum}>
                                    <td>{policyholder.policyNum}</td>
                                    <td>{policyholder.name}</td>
                                    <td>{policyholder.phoneNumber}</td>
                                    <td>{policyholder.email}</td>
                                    <td>{policyholder.address}</td>
                                    <td className='buts'>
                                        <Link className='update-btn' to={`/edit-policyholder/${policyholder.policyNum}`}>Update</Link>
                                        <button className='delete-btn' onClick={() => deletePolicyHolder(policyholder.policyNum)}>Delete</button>
                                    </td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default PolicyHolderComponent