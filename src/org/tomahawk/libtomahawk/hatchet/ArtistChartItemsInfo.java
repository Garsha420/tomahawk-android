/* == This file is part of Tomahawk Player - <http://tomahawk-player.org> ===
 *
 *   Copyright 2013, Enno Gottschalk <mrmaffen@googlemail.com>
 *
 *   Tomahawk is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   Tomahawk is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with Tomahawk. If not, see <http://www.gnu.org/licenses/>.
 */
package org.tomahawk.libtomahawk.hatchet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import java.util.ArrayList;

/**
 * Author Enno Gottschalk <mrmaffen@googlemail.com> Date: 04.05.13
 */
public class ArtistChartItemsInfo implements Info {

    private final static String TAG = ArtistChartItemsInfo.class.getName();

    public static final String ARTISTCHARTITEMSINFO_KEY_ARTISTCHARTITEMS = "ArtistChartItems";

    private ArrayList<ArtistChartItemInfo> mArtistChartItems;

    public void parseInfo(JSONObject rawInfo) {
        try {
            if (!rawInfo.isNull(ARTISTCHARTITEMSINFO_KEY_ARTISTCHARTITEMS)) {
                JSONArray rawArtistChartItemInfos = rawInfo
                        .getJSONArray(ARTISTCHARTITEMSINFO_KEY_ARTISTCHARTITEMS);
                mArtistChartItems = new ArrayList<ArtistChartItemInfo>();
                for (int i = 0; i < rawArtistChartItemInfos.length(); i++) {
                    ArtistChartItemInfo artistChartItemInfo = new ArtistChartItemInfo();
                    artistChartItemInfo.parseInfo(rawArtistChartItemInfos.getJSONObject(i));
                    mArtistChartItems.add(artistChartItemInfo);
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "parseInfo: " + e.getClass() + ": " + e.getLocalizedMessage());
        }
    }

    public ArrayList<ArtistChartItemInfo> getArtistChartItems() {
        return mArtistChartItems;
    }

}
