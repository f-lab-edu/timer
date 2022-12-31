package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new kr.co.ky.kozoltime.DataBinderMapperImpl());
  }
}
