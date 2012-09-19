/*
 * Copyright 2012 Patrik Karlsson (http://www.trixon.se)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package se.trixon.confqual;

import java.util.LinkedList;

public class Item {
	static LinkedList<Item> sItems;
	private int mDescriptionId;
	private int mKeyId;
	private int mValueId;

	static {
		sItems = new LinkedList<Item>();
		sItems.add(new Item(R.string.key_introduction, R.string.value_introduction, R.raw.introduction));
		sItems.add(new Item(R.string.key_mcc_mnc, R.string.value_na, R.raw.mcc_mnc));
		sItems.add(new Item(R.string.key_locale, R.string.value_na, R.raw.locale));
		sItems.add(new Item(R.string.key_smallest_width, R.string.value_smallestWidth, R.raw.smallest_width));
		sItems.add(new Item(R.string.key_available_width, R.string.value_availableWidth, R.raw.available_width));
		sItems.add(new Item(R.string.key_available_height, R.string.value_availableHeight, R.raw.available_height));
		sItems.add(new Item(R.string.key_size, R.string.value_size, R.raw.size));
		sItems.add(new Item(R.string.key_aspect, R.string.value_aspect, R.raw.aspect));
		sItems.add(new Item(R.string.key_orientation, R.string.value_orientation, R.raw.orientation));
		sItems.add(new Item(R.string.key_uimode, R.string.value_dockmode, R.raw.uimode));
		sItems.add(new Item(R.string.key_nightmode, R.string.value_nightmode, R.raw.nightmode));
		sItems.add(new Item(R.string.key_dpi, R.string.value_dpi, R.raw.dpi));
		sItems.add(new Item(R.string.key_touchscreen, R.string.value_touchscreen, R.raw.touchscreen));
		sItems.add(new Item(R.string.key_keyboard, R.string.value_keyboard, R.raw.keyboard));
		sItems.add(new Item(R.string.key_textinput, R.string.value_textinput, R.raw.textinput));
		sItems.add(new Item(R.string.key_navkey, R.string.value_navkey, R.raw.navkey));
		sItems.add(new Item(R.string.key_nontouchnav, R.string.value_nontouchnav, R.raw.nontouchnav));
		sItems.add(new Item(R.string.key_api, R.string.value_api, R.raw.api));
	}

	public Item() {
		super();
	}

	public Item(int keyId, int valueId, int descriptionId) {
		super();
		mKeyId = keyId;
		mValueId = valueId;
		mDescriptionId = descriptionId;
	}

	public int getDescriptionId() {
		return mDescriptionId;
	}

	public int getKeyId() {
		return mKeyId;
	}

	public int getValueId() {
		return mValueId;
	}

	public void setDescriptionId(int descriptionId) {
		this.mDescriptionId = descriptionId;
	}

	public void setKeyId(int keyId) {
		this.mKeyId = keyId;
	}

	public void setValueId(int valueId) {
		this.mValueId = valueId;
	}

}
