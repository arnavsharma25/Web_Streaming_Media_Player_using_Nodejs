// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

// Referenced classes of package android.support.v4.app:
//            h

class g
{

    private static final int a[] = {
        0x101030b
    };

    public static Drawable a(Activity activity)
    {
        TypedArray typedarray = activity.obtainStyledAttributes(a);
        Drawable drawable = typedarray.getDrawable(0);
        typedarray.recycle();
        return drawable;
    }

    public static Object a(Object obj, Activity activity, int i)
    {
        Object obj1;
        h h1;
        if (obj == null)
        {
            obj1 = new h(activity);
        } else
        {
            obj1 = obj;
        }
        h1 = (h)obj1;
        if (h1.a != null)
        {
            try
            {
                android.app.ActionBar actionbar = activity.getActionBar();
                Method method = h1.b;
                Object aobj[] = new Object[1];
                aobj[0] = Integer.valueOf(i);
                method.invoke(actionbar, aobj);
            }
            catch (Exception exception)
            {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", exception);
                return obj1;
            }
        }
        return obj1;
    }

}
