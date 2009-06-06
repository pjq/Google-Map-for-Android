package com.pjq.googlemapsample;

import android.R.integer;
import android.app.Activity;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.googlenav.GmmConstants;

public class GooglemapSample extends MapActivity implements OnClickListener
{
	/** Called when the activity is first created. */
	private MapView			mapView;
	private MapView			mapView2;
	private Button			zoomInButton;
	private Button			zoomOutButton;
	private Button			streetButton;
	private Button			trafficButton;
	private Button			satelliteButton;

	private MapController	mapController;
	private GeoPoint		gp;
	private Address    address;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	
		mapView2 = (MapView) findViewById(R.id.mapView2);
		zoomInButton = (Button) findViewById(R.id.zoomInButton);
		zoomOutButton = (Button) findViewById(R.id.zoomOutButton);
		streetButton = (Button) findViewById(R.id.streetButton);
		trafficButton = (Button) findViewById(R.id.trafficButton);
		satelliteButton = (Button) findViewById(R.id.satelliteButton);
			


		mapController = mapView2.getController();
	//	mapView.setSatellite(true);

		//hangzhou
		gp = new GeoPoint((int) (30.27 * 1000000), (int) (120.16 * 1000000));
		//mapController.animateTo(gp);
		mapController.setCenter(gp);
		//mapController.setZoom(DEFAULT_ZOOM_LEVEL);
	

	} 

	@Override
	protected boolean isRouteDisplayed()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		int id = v.getId();

		switch (id)
		{
		case R.id.zoomInButton:
			mapController.setZoom(mapView2.getZoomLevel() - 1);

			break;
		case R.id.zoomOutButton:
			mapController.setZoom(mapView2.getZoomLevel() + 1);
			break;
		case R.id.streetButton:
			mapView2.setStreetView(true);
			mapView2.setSatellite(false);
			mapView2.setTraffic(false);
			break;
		case R.id.trafficButton:
			mapView2.setStreetView(false);
			mapView2.setSatellite(false);
			mapView2.setTraffic(true);
			break;
		case R.id.satelliteButton:
			mapView2.setStreetView(false);
			mapView2.setSatellite(true);
			mapView2.setTraffic(false);
			break;

		default:
			break;
		}

	}
}