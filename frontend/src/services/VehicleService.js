import axios from "axios"

const VEHICLE_BASE_REST_API_URL = "http://localhost:9080/vehicles";

class VehicleService{
    getAllVehicles(){
      return axios.get(VEHICLE_BASE_REST_API_URL)
    }
  
    createVehicle(vehicle){
      return axios.post(VEHICLE_BASE_REST_API_URL,vehicle)
    }
  
    getVehicleByID(id){
      return axios.get(VEHICLE_BASE_REST_API_URL + '/' + id)
    }
  
    updateVehicle(id,vehicle){
      return axios.put(VEHICLE_BASE_REST_API_URL+'/'+id,vehicle)
    }
  
    deleteVehicle(id){
      return axios.delete(VEHICLE_BASE_REST_API_URL+'/'+id);
    }
  }
  
  export default new VehicleService();