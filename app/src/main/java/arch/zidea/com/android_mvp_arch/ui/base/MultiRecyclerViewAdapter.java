package arch.zidea.com.android_mvp_arch.ui.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.WeakHashMap;

import arch.zidea.com.android_mvp_arch.ui.factory.ItemTypeFactory;
import arch.zidea.com.android_mvp_arch.ui.decorator.Visitable;
import arch.zidea.com.android_mvp_arch.ui.factory.TypeFactory;

public class MultiRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    List<Visitable> mData;
    TypeFactory typeFactory;
    LayoutInflater layoutInflater;

    WeakHashMap<Integer,BaseViewHolder> hashMap = new WeakHashMap<>();

    public MultiRecyclerViewAdapter(List<Visitable> mData) {

        this.mData = mData;
        this.typeFactory = new ItemTypeFactory();

    }

    public List<Visitable> getmData() {
        return mData;
    }

    public void setmData(List<Visitable> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(viewType,parent,false);

        return typeFactory.createViewHolder(viewType,view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bindViewData(mData.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).type(typeFactory);
    }


    @Override
    public int getItemCount() {
        return (mData != null ? mData.size() : 0);
    }


}
