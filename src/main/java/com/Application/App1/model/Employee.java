package com.Application.App1.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Employee {


    //no default constructor declared
    //json property is included to make the
    //spring to resolve object when using @RequestBody
    //annotation which is not since the default constructor
    //not included in this case
    private @JsonProperty("id") UUID id;
    private @JsonProperty("name") String name;
    private @JsonProperty("department") String department;
    /* Exception, which caused by usage of same property value
    <div>Could not write JSON: Conflicting getter definitions for property &quot;id&quot;:
    com.Application.App1.model.Employee#getId(0 params) vs com.Application.App1.model.Employee#getName(0 params); nested exception is com.fasterxml.jackson.databind.JsonMappingException: Conflicting getter definitions for property &quot;id&quot;: com.Application.App1.model.Employee#getId(0 params)
    vs com.Application.App1.model.Employee#getName(0 params) (through reference chain: java.util.ArrayList[0])</div>
     */

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public Employee(UUID id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}
