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

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;

public class ConfQualApplication extends Application {

	public Dialog getAboutDialog(Context context) {
		AlertDialog.Builder builder;

		builder = new AlertDialog.Builder(context);
		builder.setTitle(getString(R.string.about));
		String message = String.format(getString(R.string.app_about), getString(R.string.app_name), getString(R.string.app_version), getString(R.string.app_copyright));
		builder.setMessage(message);
		builder.setPositiveButton(android.R.string.ok, null);

		return builder.create();
	}

	@SuppressLint("NewApi")
	public String getConfigValue(CfgKey key) {
		Configuration config = getResources().getConfiguration();
		String value = "-";
		switch (key) {
			case AH:
				if (android.os.Build.VERSION.SDK_INT >= 13) {
					value = String.format("h%ddp", config.screenHeightDp);
				} else {
					value = "API<13";
				}
				break;

			case AW:
				if (android.os.Build.VERSION.SDK_INT >= 13) {
					value = String.format("w%ddp", config.screenWidthDp);
				} else {
					value = "API<13";
				}
				break;

			case LO:
				value = String.format("%s-r%s", config.locale.getLanguage(), config.locale.getCountry());
				break;

			case MCC:
				if (config.mcc > 0) {
					value = String.format("mcc%s-mnc%s", config.mcc, config.mnc);
				}
				break;

			case SW:
				if (android.os.Build.VERSION.SDK_INT >= 13) {
					value = String.format("sw%ddp", config.smallestScreenWidthDp);
				} else {
					value = "API<13";
				}
				break;

			default:
				break;
		}

		return value;
	}

	public enum CfgKey {
		AH, AW, LO, MCC, SW;
	}
}
