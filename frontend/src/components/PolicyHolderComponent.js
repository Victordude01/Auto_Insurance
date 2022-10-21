import React,{useState,useEffect} from 'react'
import PolicyHolderService from '../services/PolicyHolderService'

const PolicyHolderComponent = () => {
    const[policyholders,setPolicyHolders] = useState([])

    useEffect(() => {
        PolicyHolderService.getAllPolicyHolders().then((response) => {
            setPolicyHolders(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
    },[])

    return (
        <div className='container'>
            <h2 className='text-center'>Policy Holders</h2>
            <table>
                <thead>
                    <th>Policy Number</th>
                    <th>Full Name</th>
                    <th>Phone Number</th>
                    <th>Email</th>
                    <th>Address</th>
                </thead>
                <tbody>
                    {
                        policyholders.map(
                            policyholder =>
                            <tr key = {policyholder.policyNum}>
                                <td>{policyholder.policyNum}</td>
                                <td>{policyholder.name}</td>
                                <td>{policyholder.phoneNumber}</td>
                                <td>{policyholder.email}</td>
                                <td>{policyholder.address}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default PolicyHolderComponent