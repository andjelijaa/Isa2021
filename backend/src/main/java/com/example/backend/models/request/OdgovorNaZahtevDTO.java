package com.example.backend.models.request;

public class OdgovorNaZahtevDTO {
    private Long id;
    private String odgovor;
    private boolean flag;

    public OdgovorNaZahtevDTO() {
    }

    public OdgovorNaZahtevDTO(Long id, String odgovor, boolean flag) {
        this.id = id;
        this.odgovor = odgovor;
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}