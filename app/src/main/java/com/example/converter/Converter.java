package com.example.converter;

public class Converter {
    //ru/usd/eur
    Double[][] currencyK = {
            {1.0, 0.013,0.011},
            {76.92,1.0,0.84},
            {90.9,1.19,1.0}
            };
    //kg/funt/oz
    Double[][] weightK = {
            {1.0, 2.442,35.274},
            {0.409,1.0,14.445},
            {0.028,0.069,1.0}
    };
    //meter/foot/yard
    Double[][] distanceK = {
            {1.0, 3.37,1.094},
            {0.29,1.0,0.333},
            {0.91,3.0,1.0}
    };

    public String Convert(int kind, int from, int to,float value)
    {
        if(kind == 1)
            return String.valueOf(value*currencyK[from][to]);
        if(kind == 2)
            return String.valueOf(value*weightK[from][to]);
        if(kind == 3)
            return String.valueOf(value*distanceK[from][to]);
        else return "";
    }

}
