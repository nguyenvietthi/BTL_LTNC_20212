/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author VIETTHI_PC
 */
public class HotelRoom {
    private int branchCode;
    private int roomCode;
    private boolean status;
    private int price;
    private String description;

    public HotelRoom(int branchCode, int roomCode, boolean status, int price, String description) {
        this.branchCode = branchCode;
        this.roomCode = roomCode;
        this.status = status;
        this.price = price;
        this.description = description;
    }

    public HotelRoom() {
    }

    public HotelRoom(int branchCode, int roomCode, boolean status, int price) {
        this.branchCode = branchCode;
        this.roomCode = roomCode;
        this.status = status;
        this.price = price;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public boolean isStatus() {
        return status;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
