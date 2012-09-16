package se.trixon.confqual;

import java.util.LinkedList;

public class Item {
	static LinkedList<Item> sItems;
	private int mDescriptionId;
	private int mKeyId;
	private int mValueId;

	static {
		sItems = new LinkedList<Item>();
		sItems.add(new Item(R.string.key_mcc_mnc, R.string.value_na, R.raw.na));
		sItems.add(new Item(R.string.key_locale, R.string.value_na, R.raw.na));
		sItems.add(new Item(R.string.key_smallest_width, R.string.value_smallestWidth, R.raw.na));
		sItems.add(new Item(R.string.key_available_width, R.string.value_availableWidth, R.raw.na));
		sItems.add(new Item(R.string.key_available_height, R.string.value_availableHeight, R.raw.na));
		sItems.add(new Item(R.string.key_size, R.string.value_size, R.raw.size));
		sItems.add(new Item(R.string.key_aspect, R.string.value_aspect, R.raw.na));
		sItems.add(new Item(R.string.key_orientation, R.string.value_orientation, R.raw.na));
		sItems.add(new Item(R.string.key_uimode, R.string.value_dockmode, R.raw.na));
		sItems.add(new Item(R.string.key_nightmode, R.string.value_nightmode, R.raw.na));
		sItems.add(new Item(R.string.key_dpi, R.string.value_dpi, R.raw.na));
		sItems.add(new Item(R.string.key_touchscreen, R.string.value_touchscreen, R.raw.na));
		sItems.add(new Item(R.string.key_keyboard, R.string.value_keyboard, R.raw.na));
		sItems.add(new Item(R.string.key_textinput, R.string.value_textinput, R.raw.na));
		sItems.add(new Item(R.string.key_navkey, R.string.value_navkey, R.raw.na));
		sItems.add(new Item(R.string.key_nontouchnav, R.string.value_nontouchnav, R.raw.na));
		sItems.add(new Item(R.string.key_api, R.string.value_api, R.raw.na));
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
