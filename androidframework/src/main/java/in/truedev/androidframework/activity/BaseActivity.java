package in.truedev.androidframework.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
/**
 * @author lakshaygirdhar
 * @version 1.0
 * @since 24/10/16
 *
 */

public abstract class BaseActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());
    }

    public abstract String getScreenName();

    protected abstract View getActivityLayout();
}
