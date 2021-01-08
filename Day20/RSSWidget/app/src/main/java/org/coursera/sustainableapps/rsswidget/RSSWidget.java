package org.coursera.sustainableapps.rsswidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class RSSWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        final int nrOfWidgets = appWidgetIds.length;
        for (int i = 0 ; i < nrOfWidgets; i++){
            int widgetID = appWidgetIds[i];
            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.r_s_s_widget);

            Intent intent = new Intent(context,NewsService.class);
            intent.putExtra("appWidgetID", widgetID);
            context.startService(intent);

            appWidgetManager.updateAppWidget(widgetID,views);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created

    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}