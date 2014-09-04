/**
 * AndTinder v0.1 for Android
 *
 * @Author: Enrique López Mañas <eenriquelopez@gmail.com>
 * http://www.lopez-manas.com
 *
 * TAndTinder is a native library for Android that provide a
 * Tinder card like effect. A card can be constructed using an
 * image and displayed with animation effects, dismiss-to-like
 * and dismiss-to-unlike, and use different sorting mechanisms.
 *
 * AndTinder is compatible with API Level 13 and upwards
 *
 * @copyright: Enrique López Mañas
 * @license: Apache License 2.0
 */

package com.andtinder.demo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.andtinder.model.CardModel;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;

public class MainActivity extends Activity {

	/**
	 * This variable is the container that will host our cards
	 */
	private CardContainer mCardContainer;
	private LinearLayout linearLayout;
	final static int INTERVAL = 800; // 1 second
    boolean whichColor = true;
    
	private static int count = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainlayout);

		mCardContainer = (CardContainer) findViewById(R.id.layoutview);
		linearLayout = (LinearLayout) findViewById(R.id.layoutfull);
		Resources r = getResources();

		SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);

		adapter.add(new CardModel("Title1 dvdlkvnfd df, dfpgvd fvfoif ?",
				"Description goes here", r.getDrawable(R.drawable.picture1)));
		adapter.add(new CardModel(
				"Description goes here Description goes hereDescription goes here ?",
				"Description goes here", r.getDrawable(R.drawable.picture2)));
		adapter.add(new CardModel("Description goes here Description goes her",
				"Description goes here", r.getDrawable(R.drawable.picture3)));

		CardModel cardModel = new CardModel(
				"Title1 \n fzfzfzfeffefzefzefeefezfzefe fezfzefzefeffzefezfe efezfzefzefefzeuh ???",
				"Description goes here", r.getDrawable(R.drawable.picture1));
		cardModel.setOnClickListener(new CardModel.OnClickListener() {
			@Override
			public void OnClickListener() {
				Log.i("Swipeable Cards", "I am pressing the card");
			}
		});

	
	
		cardModel
				.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
					@Override
					public void onTrue() {
						Log.i("Swipeable Cards", "True");
						count++;
						linearLayout.setBackgroundColor(Color.GREEN);

						  new Thread(new Runnable() {
					            public void run() {
					                while (true) {
					                    try {
					                        Thread.sleep(INTERVAL);
					                    } 
					                    catch (InterruptedException e) {
					                        e.printStackTrace();
					                    }
					                    updateColor();
					                    
					                }
					            }
					        }).start();
					}

					@Override
					public void onFalse() {
						Log.i("Swipeable Cards", "False");
						count--;
						linearLayout.setBackgroundColor(Color.RED);

						  new Thread(new Runnable() {
					            public void run() {
					                while (true) {
					                    try {
					                        Thread.sleep(INTERVAL);
					                    } 
					                    catch (InterruptedException e) {
					                        e.printStackTrace();
					                    }
					                    updateColor();
					                    
					                }
					            }
					        }).start();

					}
				});

		adapter.add(cardModel);

		mCardContainer.setAdapter(adapter);
	}

    private void updateColor() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
         
                	linearLayout.setBackgroundColor(Color.WHITE);
               
            }
        });
    }
}
