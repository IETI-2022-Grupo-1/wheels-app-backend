package com.wheelsapp.services.cars;


import com.wheelsapp.entities.cars.Vehicle;
import com.wheelsapp.entities.users.User;
import com.wheelsapp.repositories.cars.VehicleRepository;
import com.wheelsapp.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.wheelsapp.utils.RoleEnum.DRIVER;

@Service
public class VehicleServiceIMPL implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    public VehicleServiceIMPL(@Autowired VehicleRepository vehicleRepository, @Autowired UserRepository userRepository){
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }
    @Override
    public Vehicle create(Vehicle vehicle) {
        vehicle.setCreatedAt(new Date());
        vehicle.setLastUpdate(new Date());
        User user = userRepository.findById(vehicle.getIdUser()).orElse(null);
        user.addRole(DRIVER);
        userRepository.save(user);
        return vehicleRepository.save(vehicle);
    }
    @Override
    public List<Vehicle> findAllByIdUser(String idUser) {
        List<Vehicle> x = vehicleRepository.findAll();
        List<Vehicle> y = new ArrayList<Vehicle>();
        for(Integer i = 0; i<x.size();i++){
            if(idUser.equals(x.get(i).getIdUser())){
                y.add(x.get(i));
            }
        }
        return y;
    }
    @Override
    public List<Vehicle> getAllVehicle() {

        return vehicleRepository.findAll();
    }


    @Override
    public Vehicle getByVehicleId(String id){
        return vehicleRepository.findById(id).orElse(null);
    }


    @Override
    public Vehicle disableById(String id) {
        Vehicle vehicle =vehicleRepository.findById(id).orElse(null);
        vehicle.setIsActive(false);
        vehicle.setLastUpdate(new Date());
        vehicleRepository.save(vehicle);
        return vehicle;
    }
    @Override
    public Vehicle updateVehicle(Vehicle vehicle, String id){
        Vehicle vehicle1 = vehicleRepository.findById(id).orElse(null);
        vehicle1.setDescription(vehicle.getDescription());
        vehicle1.setIsActive(vehicle.getIsActive());
        vehicle1.setModel(vehicle.getModel());
        vehicle1.setIdUser(vehicle.getIdUser());
        vehicle1.setSoat(vehicle.getSoat());
        vehicle1.setPuestos(vehicle.getPuestos());
        vehicle1.setPropertyCard(vehicle.getPropertyCard());
        vehicle1.setPhoto(vehicle.getPhoto());
        vehicle1.setLastUpdate(new Date());
        vehicleRepository.save(vehicle1);
        return vehicle1;
    }
}
