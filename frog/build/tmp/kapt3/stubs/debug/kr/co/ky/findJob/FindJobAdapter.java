package kr.co.ky.findJob;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lkr/co/ky/findJob/FindJobAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lkr/co/ky/findJob/FindJobAdapter$ViewHolder;", "jobList", "", "Lkr/co/ky/findJob/FindJobDataClass;", "(Ljava/util/List;)V", "getJobList", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "frog_debug"})
public final class FindJobAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<kr.co.ky.findJob.FindJobAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<kr.co.ky.findJob.FindJobDataClass> jobList = null;
    
    public FindJobAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<kr.co.ky.findJob.FindJobDataClass> jobList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kr.co.ky.findJob.FindJobDataClass> getJobList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kr.co.ky.findJob.FindJobAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    kr.co.ky.findJob.FindJobAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lkr/co/ky/findJob/FindJobAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lkr/co/ky/kozoltime/databinding/FindJobCardviewBinding;", "(Lkr/co/ky/kozoltime/databinding/FindJobCardviewBinding;)V", "bind", "", "title", "", "date", "officeName", "context", "frog_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final kr.co.ky.kozoltime.databinding.FindJobCardviewBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        kr.co.ky.kozoltime.databinding.FindJobCardviewBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.Nullable()
        java.lang.String title, @org.jetbrains.annotations.Nullable()
        java.lang.String date, @org.jetbrains.annotations.Nullable()
        java.lang.String officeName, @org.jetbrains.annotations.Nullable()
        java.lang.String context) {
        }
    }
}