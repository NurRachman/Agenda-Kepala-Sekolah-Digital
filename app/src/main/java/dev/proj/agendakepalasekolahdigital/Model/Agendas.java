package dev.proj.agendakepalasekolahdigital.Model;

public class Agendas {
    private String agenda, lokasi, waktu, date;
    private Boolean repeat;

    public Agendas(String agenda, String lokasi, String waktu, String date, Boolean repeat) {
        this.agenda = agenda;
        this.lokasi = lokasi;
        this.waktu = waktu;
        this.date = date;
        this.repeat = repeat;
    }

    public Agendas() {
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getRepeat() {
        return repeat;
    }

    public void setRepeat(Boolean repeat) {
        this.repeat = repeat;
    }
}
