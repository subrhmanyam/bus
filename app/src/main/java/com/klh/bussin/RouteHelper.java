package com.klh.bussin;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class RouteHelper {


    public static  RouteInfo getRoute1Info() {
        RouteInfo info = new RouteInfo();

        LatLng pargatinagar = new LatLng(17.5186, 78.3963);
        LatLng miyapur = new LatLng(17.4699, 78.3578);
        LatLng haffezpet = new LatLng(17.484168, 78.360294);

        info.source = pargatinagar;
        info.destination = haffezpet;
        ArrayList<LatLng> wayPoint = new ArrayList<>();
        wayPoint.add(miyapur);
        wayPoint.add(haffezpet);
        return info;
    }


    public static  RouteInfo getRoute2Info() {
        RouteInfo info = new RouteInfo();

        LatLng pargatinagar = new LatLng(17.5186, 78.3963);
        LatLng miyapur = new LatLng(17.4699, 78.3578);
        LatLng haffezpet = new LatLng(17.484168, 78.360294);

        info.source = pargatinagar;
        info.destination = haffezpet;
        ArrayList<LatLng> wayPoint = new ArrayList<>();
        wayPoint.add(miyapur);
        return info;
    }


    public static  RouteInfo getRoute3Info() {
        RouteInfo info = new RouteInfo();

        LatLng pargatinagar = new LatLng(17.5186, 78.3963);
        LatLng miyapur = new LatLng(17.4699, 78.3578);
        LatLng haffezpet = new LatLng(17.484168, 78.360294);

        info.source = pargatinagar;
        info.destination = haffezpet;
        ArrayList<LatLng> wayPoint = new ArrayList<>();
        wayPoint.add(miyapur);
        return info;
    }

    public static  RouteInfo getRoute4Info() {
        RouteInfo info = new RouteInfo();

        LatLng pargatinagar = new LatLng(17.5186, 78.3963);
        LatLng miyapur = new LatLng(17.4699, 78.3578);
        LatLng haffezpet = new LatLng(17.484168, 78.360294);

        info.source = pargatinagar;
        info.destination = haffezpet;
        ArrayList<LatLng> wayPoint = new ArrayList<>();
        wayPoint.add(miyapur);
        return info;
    }

    public static  RouteInfo getRoute5Info() {
        RouteInfo info = new RouteInfo();

        LatLng pargatinagar = new LatLng(17.5186, 78.3963);
        LatLng miyapur = new LatLng(17.4699, 78.3578);
        LatLng haffezpet = new LatLng(17.484168, 78.360294);

        info.source = pargatinagar;
        info.destination = haffezpet;
        ArrayList<LatLng> wayPoint = new ArrayList<>();
        wayPoint.add(miyapur);
        return info;
    }
}

