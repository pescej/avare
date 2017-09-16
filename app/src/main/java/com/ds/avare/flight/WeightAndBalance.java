/*
Copyright (c) 2012, Apps4Av Inc. (apps4av.com) 
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
    *     * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    *
    *     THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package com.ds.avare.flight;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

/**
 * All lists get stored and get retrieved in JSON format
 * @author zkhan
 *
 */
public class WeightAndBalance {


    JSONObject mWnb;

    /**
     * From JSON
     * @param json
     */
    public WeightAndBalance(JSONObject json) {
        mWnb = json;
    }

    /**
     * Get in JSON format
     * @return
     */
    public JSONObject getJSON() {
        return mWnb;
    }
    
    /**
     * 
     * @return
     */
    public String getName() {
        try {
            return mWnb.getString("name");
        } catch (JSONException e) {
        }
        return "";
    }

    /**
     * Put a list of WNBs in JSON array
     * @param wnbs
     * @return
     */
    public static String putWnbsToStorageFormat(LinkedList<WeightAndBalance> wnbs) {
        
        JSONArray jsonArr = new JSONArray();
        for(WeightAndBalance w : wnbs) {
            
            JSONObject o = w.getJSON();
            jsonArr.put(o);
        }
        
        return jsonArr.toString();
    }
    
    /**
     * Gets an array of WNBs from storage JSON
     * @return
     */
    public static LinkedList<WeightAndBalance> getWnbsFromStorageFromat(String json) {
        JSONArray jsonArr;
        LinkedList<WeightAndBalance> ret = new LinkedList<WeightAndBalance>();
        try {
            jsonArr = new JSONArray(json);
        } catch (JSONException e) {
            return ret;
        }
        
        for(int i = 0; i < jsonArr.length(); i++) {
            try {
                JSONObject o = jsonArr.getJSONObject(i);
                ret.add(new WeightAndBalance(o));
            } catch (JSONException e) {
                continue;
            }
        }
        
        return ret;
    }

}