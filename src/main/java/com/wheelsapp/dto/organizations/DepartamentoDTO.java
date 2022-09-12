package com.wheelsapp.dto.organizations;

import com.wheelsapp.entities.organizations.Departamento;

public class DepartamentoDTO {

    private  String name;

    public DepartamentoDTO(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Departamento changingToEntitie(DepartamentoDTO departamentoDTO){
        Departamento departamento = new Departamento(departamentoDTO.getName());
        return departamento;
    }
}
