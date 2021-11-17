/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detai14;

import java.util.Random;

/**
 *
 * @author ACER
 */
public class PhanSo {
    private int tuSo;
    private int mauSo;

    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
    public PhanSo() {
        Random generator = new Random();
        tuSo=generator.nextInt();
        mauSo=generator.nextInt();
        //random lại mẫu số nếu mẫu số bằng 0;
        while(mauSo==0) mauSo=generator.nextInt();
    }
    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }

 
    public boolean laNguyenTo()
    {
        int ms=this.mauSo;
        if(ms<2) return false;
        for(int i=2; i<ms; i++)
        {
            if(ms%i==0) return false;
        }
        return true;
    }   
    
}
