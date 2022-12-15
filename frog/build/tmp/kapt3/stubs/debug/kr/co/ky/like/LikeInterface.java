package kr.co.ky.like;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lkr/co/ky/like/LikeInterface;", "", "ClickLike", "", "collection", "", "documentList", "", "Lkr/co/ky/community/CommunityDataClass;", "position", "", "frog_debug"})
public abstract interface LikeInterface {
    
    public abstract void ClickLike(@org.jetbrains.annotations.NotNull()
    java.lang.String collection, @org.jetbrains.annotations.NotNull()
    java.util.List<kr.co.ky.community.CommunityDataClass> documentList, int position);
}