package com.wheelsapp.entities.organizations;

import com.wheelsapp.dto.organizations.DepartamentoDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Departamento {
    @Id
    private  String id;
    @Indexed(unique = true)
    private  String name;

    public Departamento(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public DepartamentoDTO changingToDTO(Departamento departamento){
        DepartamentoDTO departamentoDTO = new DepartamentoDTO(departamento.getName());
        return departamentoDTO;
    }
}
