/*
 *          Copyright (C) 2016 jarlen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package cn.jarlen.richcommon.mvp.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

import cn.jarlen.richcommon.mvp.view.IBaseView;

/**
 * Created by jarlen on 2016/11/23.
 */
public abstract class BaseActivityPresenter<V extends IBaseView> {

    private V v;

    private FragmentActivity activity;

    private Intent intent;

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public void setView(V v) {
        this.v = v;
    }

    public void setActivity(FragmentActivity activity) {
        this.activity = activity;
    }

    public FragmentActivity getActivity() {
        return activity;
    }

    public V getView() {
        return v;
    }

    public Intent getIntent() {
        return intent;
    }

    public void onBindView(Bundle savedInstanceState) {
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onRestart() {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }
}
