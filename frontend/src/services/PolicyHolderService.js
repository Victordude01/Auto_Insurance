import axios from "axios"

const POLICYHOLDER_BASE_REST_API_URL = "http://localhost:9080/policyholders";

class PolicyHolderService{
  getAllPolicyHolders(){
    return axios.get(POLICYHOLDER_BASE_REST_API_URL)
  }

  createPolicyHolder(policyholder){
    return axios.post(POLICYHOLDER_BASE_REST_API_URL,policyholder)
  }

  getPolicyHolderByID(id){
    return axios.get(POLICYHOLDER_BASE_REST_API_URL + '/' + id)
  }
}

export default new PolicyHolderService();