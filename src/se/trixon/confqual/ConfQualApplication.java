package se.trixon.confqual;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;

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
}
