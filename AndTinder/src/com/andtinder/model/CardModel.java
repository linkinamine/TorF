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

package com.andtinder.model;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class CardModel {

	private String questionText;
	private Drawable cardImageDrawable;

	private OnCardDimissedListener mOnCardDimissedListener = null;

	private OnClickListener mOnClickListener = null;

	public interface OnCardDimissedListener {
		void onFalse();

		void onTrue();
	}

	public interface OnClickListener {
		void OnClickListener();
	}

	public CardModel() {
		this(null, null, (Drawable) null);
	}

	public CardModel(String title, String description, Drawable cardImage) {
		this.questionText = title;
		this.cardImageDrawable = cardImage;
	}

	public CardModel(String title, String description, Bitmap cardImage) {
		this.questionText = title;
		this.cardImageDrawable = new BitmapDrawable(null, cardImage);
	}

	public String getTitle() {
		return questionText;
	}

	public void setTitle(String title) {
		this.questionText = title;
	}

	public Drawable getCardImageDrawable() {
		return cardImageDrawable;
	}

	public void setCardImageDrawable(Drawable cardImageDrawable) {
		this.cardImageDrawable = cardImageDrawable;
	}

	public void setOnCardDimissedListener(OnCardDimissedListener listener) {
		this.mOnCardDimissedListener = listener;
	}

	public OnCardDimissedListener getOnCardDimissedListener() {
		return this.mOnCardDimissedListener;
	}

	public void setOnClickListener(OnClickListener listener) {
		this.mOnClickListener = listener;
	}

	public OnClickListener getOnClickListener() {
		return this.mOnClickListener;
	}
}