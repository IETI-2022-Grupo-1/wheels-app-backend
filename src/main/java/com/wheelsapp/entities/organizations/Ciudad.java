package com.wheelsapp.entities.organizations;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;
import com.wheelsapp.dto.organizations.CiudadDTO;
import org.springframework.data.annotation.Id;

public class Ciudad{
    @Id
    String id;
    public String name;

    public Ciudad(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CiudadDTO changingToDTO(Ciudad ciudad){
        CiudadDTO ciudadDTO = new CiudadDTO(ciudad.getName());
        return ciudadDTO;
    }
}