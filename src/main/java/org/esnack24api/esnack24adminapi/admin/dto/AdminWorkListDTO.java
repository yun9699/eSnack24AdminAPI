package org.esnack24api.esnack24adminapi.admin.dto;

import lombok.Data;

@Data
public class AdminWorkListDTO {

    private Long admno;

    private String admid;

    private String admname;

    private String admrole;

    private int count;
}