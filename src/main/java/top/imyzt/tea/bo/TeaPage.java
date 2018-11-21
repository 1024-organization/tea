package top.imyzt.tea.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by imyzt on 2018/11/21 15:42
 */
@Data
public class TeaPage<T> implements Serializable{

    private long count;

    private long limit;

    private List<T> data;

    public TeaPage() {
    }

    public TeaPage(long count, long limit, List<T> data) {
        this.count = count;
        this.limit = limit;
        this.data = data;
    }
}
