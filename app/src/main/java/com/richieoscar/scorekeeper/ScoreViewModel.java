package com.richieoscar.scorekeeper;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {

    private static int ONE_POINT = 1;
    private static int THREE_POINTS = 3;
    private int sumTeamA;
    private int sumTeamB;
    private int sumPointsA;
    private int sumPointsB;
    private int sumPkTeamA;
    private int sumPkTeamB;
    private int sumFKTeamA;
    private int sumFKTeamB;


    public int getSumTeamA() {
        return sumTeamA;
    }

    public void setSumTeamA(int sumTeamA) {
        this.sumTeamA = sumTeamA;
    }

    public int getSumTeamB() {
        return sumTeamB;
    }

    public void setSumTeamB(int sumTeamB) {
        this.sumTeamB = sumTeamB;
    }

    public int getSumPointsA() {
        return sumPointsA;
    }

    public void setSumPointsA(int sumPointsA) {
        this.sumPointsA = sumPointsA;
    }

    public int getSumPointsB() {
        return sumPointsB;
    }

    public void setSumPointsB(int sumPointsB) {
        this.sumPointsB = sumPointsB;
    }

    public int getSumPkTeamA() {
        return sumPkTeamA;
    }

    public void setSumPkTeamA(int sumPkTeamA) {
        this.sumPkTeamA = sumPkTeamA;
    }

    public int getSumPkTeamB() {
        return sumPkTeamB;
    }

    public void setSumPkTeamB(int sumPkTeamB) {
        this.sumPkTeamB = sumPkTeamB;
    }

    public int getSumFKTeamA() {
        return sumFKTeamA;
    }

    public void setSumFKTeamA(int sumFKTeamA) {
        this.sumFKTeamA = sumFKTeamA;
    }

    public int getSumFKTeamB() {
        return sumFKTeamB;
    }

    public void setSumFKTeamB(int sumFKTeamB) {
        this.sumFKTeamB = sumFKTeamB;
    }




    public int incrementScoreForTeamA(){
        sumTeamA = sumTeamA + ONE_POINT;
        return  sumTeamA;
    }

    public int incrementScoreForTeamB(){
        sumTeamB = sumTeamB + ONE_POINT;
        return  sumTeamB;

    }

    public int incrementPointForTeamA(){
       return sumPointsA = sumPointsA  +THREE_POINTS;
    }

    public  int incrementPointForTeamB(){
       return sumPointsB = sumPointsB + THREE_POINTS;

    }

    public  int incrementPkForTeamA(){
       return sumPkTeamA = sumPkTeamA + ONE_POINT;
    }
    public  int incrementPkForTeamB(){
        return sumPkTeamB = sumPkTeamB + ONE_POINT;
    }

    public  int incrementFKForTeamA(){
        return  sumFKTeamA = sumFKTeamA + ONE_POINT;
    }
    public int incrementFkForTeamB(){
        return  sumFKTeamB = sumFKTeamB + ONE_POINT;
    }
    public void reset(){
        sumFKTeamA = 0;
        sumFKTeamB = 0;
        sumPointsA = 0;
        sumPointsB  =0;
        sumPkTeamA = 0;
        sumPkTeamB = 0;
        sumTeamA = 0;
        sumTeamB = 0;

    }
}
