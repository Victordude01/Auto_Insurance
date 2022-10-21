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

  updatePolicyHolder(id,policyholder){
    return axios.put(POLICYHOLDER_BASE_REST_API_URL+'/'+id,policyholder)
  }

  deletePolicyHolder(id){
    return axios.delete(POLICYHOLDER_BASE_REST_API_URL+'/'+id);
  }
}

export default new PolicyHolderService();