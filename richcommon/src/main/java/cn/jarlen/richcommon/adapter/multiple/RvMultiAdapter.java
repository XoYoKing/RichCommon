/*
 * Copyright (C) 2016 jarlen
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.jarlen.richcommon.adapter.multiple;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.jarlen.richcommon.adapter.RvViewHolder;

/**
 * DESCRIBE:
 * Created by jarlen on 2017/1/11.
 */

public abstract class RvMultiAdapter<D> extends RecyclerView.Adapter<RvViewHolder> {

    public Context mContext = null;

    private AdapterDelegatesManager<List<D>> delegatesManager;

    protected List<D> listData = new ArrayList<D>();

    public RvMultiAdapter(Context context) {
        this.mContext = context;
        delegatesManager = new AdapterDelegatesManager<List<D>>();
    }

    @Override
    public int getItemViewType(int position) {
        return delegatesManager.getItemViewType(listData, position);
    }

    @Override
    public RvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RvViewHolder holder, int position) {
        delegatesManager.onBindViewHolder(listData, position, holder);
    }

    @Override
    public void onBindViewHolder(RvViewHolder holder, int position, List payloads) {
        delegatesManager.onBindViewHolder(listData, position, holder, payloads);
    }

    @Override
    public int getItemCount() {
        if (listData == null) {
            return 0;
        }
        return listData.size();
    }

    public void addDataList(List<D> mList) {
        if (listData != null) {
            listData.addAll(mList);
        }
        this.notifyDataSetChanged();
    }

    public void addData(D data) {
        if (listData != null) {
            listData.add(data);
        }
        this.notifyDataSetChanged();
    }

    public void clearDataList() {
        if (listData != null) {
            listData.clear();
        }
        this.notifyDataSetChanged();
    }

    public void removeData(int position) {
        if (listData != null) {
            listData.remove(position);
        }
        this.notifyDataSetChanged();
    }


}
