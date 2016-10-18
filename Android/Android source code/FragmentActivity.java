// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

// Referenced classes of package android.support.v4.app:
//            p, w, q, ah, 
//            i, Fragment, s, r, 
//            t

public class FragmentActivity extends Activity
{

    final Handler a = new p(this);
    final w b = new w();
    final t c = new q(this);
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    HashMap l;
    ah m;

    public FragmentActivity()
    {
    }

    private static String a(View view)
    {
        char c1;
        char c2;
        StringBuilder stringbuilder;
        c1 = 'F';
        c2 = '.';
        stringbuilder = new StringBuilder(128);
        stringbuilder.append(view.getClass().getName());
        stringbuilder.append('{');
        stringbuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringbuilder.append(' ');
        view.getVisibility();
        JVM INSTR lookupswitch 3: default 92
    //                   0: 497
    //                   4: 507
    //                   8: 517;
           goto _L1 _L2 _L3 _L4
_L1:
        stringbuilder.append(c2);
_L11:
        String s1;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        char c8;
        char c9;
        char c10;
        int i1;
        Resources resources;
        String s2;
        String s3;
        if (view.isFocusable())
        {
            c3 = c1;
        } else
        {
            c3 = c2;
        }
        stringbuilder.append(c3);
        if (view.isEnabled())
        {
            c4 = 'E';
        } else
        {
            c4 = c2;
        }
        stringbuilder.append(c4);
        if (view.willNotDraw())
        {
            c5 = c2;
        } else
        {
            c5 = 'D';
        }
        stringbuilder.append(c5);
        if (view.isHorizontalScrollBarEnabled())
        {
            c6 = 'H';
        } else
        {
            c6 = c2;
        }
        stringbuilder.append(c6);
        if (view.isVerticalScrollBarEnabled())
        {
            c7 = 'V';
        } else
        {
            c7 = c2;
        }
        stringbuilder.append(c7);
        if (view.isClickable())
        {
            c8 = 'C';
        } else
        {
            c8 = c2;
        }
        stringbuilder.append(c8);
        if (view.isLongClickable())
        {
            c9 = 'L';
        } else
        {
            c9 = c2;
        }
        stringbuilder.append(c9);
        stringbuilder.append(' ');
        if (!view.isFocused())
        {
            c1 = c2;
        }
        stringbuilder.append(c1);
        if (view.isSelected())
        {
            c10 = 'S';
        } else
        {
            c10 = c2;
        }
        stringbuilder.append(c10);
        if (view.isPressed())
        {
            c2 = 'P';
        }
        stringbuilder.append(c2);
        stringbuilder.append(' ');
        stringbuilder.append(view.getLeft());
        stringbuilder.append(',');
        stringbuilder.append(view.getTop());
        stringbuilder.append('-');
        stringbuilder.append(view.getRight());
        stringbuilder.append(',');
        stringbuilder.append(view.getBottom());
        i1 = view.getId();
        if (i1 == -1) goto _L6; else goto _L5
_L5:
        stringbuilder.append(" #");
        stringbuilder.append(Integer.toHexString(i1));
        resources = view.getResources();
        if (i1 == 0 || resources == null) goto _L6; else goto _L7
_L7:
        0xff000000 & i1;
        JVM INSTR lookupswitch 2: default 416
    //                   16777216: 588
    //                   2130706432: 581;
           goto _L8 _L9 _L10
_L8:
        s1 = resources.getResourcePackageName(i1);
_L12:
        s2 = resources.getResourceTypeName(i1);
        s3 = resources.getResourceEntryName(i1);
        stringbuilder.append(" ");
        stringbuilder.append(s1);
        stringbuilder.append(":");
        stringbuilder.append(s2);
        stringbuilder.append("/");
        stringbuilder.append(s3);
_L6:
        stringbuilder.append("}");
        return stringbuilder.toString();
_L2:
        stringbuilder.append('V');
          goto _L11
_L3:
        stringbuilder.append('I');
          goto _L11
_L4:
        stringbuilder.append('G');
          goto _L11
_L10:
        s1 = "app";
          goto _L12
_L9:
        s1 = "android";
          goto _L12
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
          goto _L6
    }

    private void a(String s1, PrintWriter printwriter, View view)
    {
        printwriter.print(s1);
        if (view != null) goto _L2; else goto _L1
_L1:
        printwriter.println("null");
_L4:
        return;
_L2:
        printwriter.println(a(view));
        if (view instanceof ViewGroup)
        {
            ViewGroup viewgroup = (ViewGroup)view;
            int i1 = viewgroup.getChildCount();
            if (i1 > 0)
            {
                String s2 = (new StringBuilder()).append(s1).append("  ").toString();
                int j1 = 0;
                while (j1 < i1) 
                {
                    a(s2, printwriter, viewgroup.getChildAt(j1));
                    j1++;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ah a(String s1, boolean flag, boolean flag1)
    {
        if (l == null)
        {
            l = new HashMap();
        }
        ah ah1 = (ah)l.get(s1);
        if (ah1 == null)
        {
            if (flag1)
            {
                ah1 = new ah(s1, this, flag);
                l.put(s1, ah1);
            }
            return ah1;
        } else
        {
            ah1.a(this);
            return ah1;
        }
    }

    protected void a()
    {
        b.m();
    }

    public void a(Fragment fragment)
    {
    }

    void a(String s1)
    {
        if (l != null)
        {
            ah ah1 = (ah)l.get(s1);
            if (ah1 != null && !ah1.g)
            {
                ah1.h();
                l.remove(s1);
            }
        }
    }

    void a(boolean flag)
    {
        if (!g)
        {
            g = true;
            h = flag;
            a.removeMessages(1);
            d();
        }
    }

    public Object b()
    {
        return null;
    }

    public void c()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            android.support.v4.app.i.a(this);
            return;
        } else
        {
            i = true;
            return;
        }
    }

    void d()
    {
        if (k)
        {
            k = false;
            if (m != null)
            {
                if (!h)
                {
                    m.c();
                } else
                {
                    m.d();
                }
            }
        }
        b.p();
    }

    public void dump(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        if (android.os.Build.VERSION.SDK_INT < 11);
        printwriter.print(s1);
        printwriter.print("Local FragmentActivity ");
        printwriter.print(Integer.toHexString(System.identityHashCode(this)));
        printwriter.println(" State:");
        String s2 = (new StringBuilder()).append(s1).append("  ").toString();
        printwriter.print(s2);
        printwriter.print("mCreated=");
        printwriter.print(d);
        printwriter.print("mResumed=");
        printwriter.print(e);
        printwriter.print(" mStopped=");
        printwriter.print(f);
        printwriter.print(" mReallyStopped=");
        printwriter.println(g);
        printwriter.print(s2);
        printwriter.print("mLoadersStarted=");
        printwriter.println(k);
        if (m != null)
        {
            printwriter.print(s1);
            printwriter.print("Loader Manager ");
            printwriter.print(Integer.toHexString(System.identityHashCode(m)));
            printwriter.println(":");
            m.a((new StringBuilder()).append(s1).append("  ").toString(), filedescriptor, printwriter, as);
        }
        b.a(s1, filedescriptor, printwriter, as);
        printwriter.print(s1);
        printwriter.println("View Hierarchy:");
        a((new StringBuilder()).append(s1).append("  ").toString(), printwriter, getWindow().getDecorView());
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        b.i();
        int k1 = i1 >> 16;
        if (k1 != 0)
        {
            int l1 = k1 - 1;
            if (b.f == null || l1 < 0 || l1 >= b.f.size())
            {
                Log.w("FragmentActivity", (new StringBuilder()).append("Activity result fragment index out of range: 0x").append(Integer.toHexString(i1)).toString());
                return;
            }
            Fragment fragment = (Fragment)b.f.get(l1);
            if (fragment == null)
            {
                Log.w("FragmentActivity", (new StringBuilder()).append("Activity result no fragment exists for index: 0x").append(Integer.toHexString(i1)).toString());
                return;
            } else
            {
                fragment.a(0xffff & i1, j1, intent);
                return;
            }
        } else
        {
            super.onActivityResult(i1, j1, intent);
            return;
        }
    }

    public void onBackPressed()
    {
        if (!b.c())
        {
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        b.a(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        b.a(this, c, null);
        if (getLayoutInflater().getFactory() == null)
        {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        s s1 = (s)getLastNonConfigurationInstance();
        if (s1 != null)
        {
            l = s1.e;
        }
        if (bundle != null)
        {
            android.os.Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            w w1 = b;
            ArrayList arraylist;
            if (s1 != null)
            {
                arraylist = s1.d;
            } else
            {
                arraylist = null;
            }
            w1.a(parcelable, arraylist);
        }
        b.j();
    }

    public boolean onCreatePanelMenu(int i1, Menu menu)
    {
        if (i1 == 0)
        {
            boolean flag = super.onCreatePanelMenu(i1, menu) | b.a(menu, getMenuInflater());
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                return flag;
            } else
            {
                return true;
            }
        } else
        {
            return super.onCreatePanelMenu(i1, menu);
        }
    }

    public View onCreateView(String s1, Context context, AttributeSet attributeset)
    {
        if (!"fragment".equals(s1))
        {
            return super.onCreateView(s1, context, attributeset);
        }
        String s2 = attributeset.getAttributeValue(null, "class");
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, r.a);
        if (s2 == null)
        {
            s2 = typedarray.getString(0);
        }
        int i1 = typedarray.getResourceId(1, -1);
        String s3 = typedarray.getString(2);
        typedarray.recycle();
        int j1 = 0;
        if (false)
        {
            j1 = null.getId();
        }
        if (j1 == -1 && i1 == -1 && s3 == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Must specify unique android:id, android:tag, or have a parent with an id for ").append(s2).toString());
        }
        Fragment fragment = null;
        if (i1 != -1)
        {
            fragment = b.a(i1);
        }
        if (fragment == null && s3 != null)
        {
            fragment = b.a(s3);
        }
        if (fragment == null && j1 != -1)
        {
            fragment = b.a(j1);
        }
        if (w.a)
        {
            Log.v("FragmentActivity", (new StringBuilder()).append("onCreateView: id=0x").append(Integer.toHexString(i1)).append(" fname=").append(s2).append(" existing=").append(fragment).toString());
        }
        if (fragment == null)
        {
            Fragment fragment1 = Fragment.a(this, s2);
            fragment1.o = true;
            int k1;
            if (i1 != 0)
            {
                k1 = i1;
            } else
            {
                k1 = j1;
            }
            fragment1.w = k1;
            fragment1.x = j1;
            fragment1.y = s3;
            fragment1.p = true;
            fragment1.s = b;
            fragment1.a(this, attributeset, fragment1.d);
            b.a(fragment1, true);
            fragment = fragment1;
        } else
        {
            if (fragment.p)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Duplicate id 0x").append(Integer.toHexString(i1)).append(", tag ").append(s3).append(", or parent id 0x").append(Integer.toHexString(j1)).append(" with another fragment for ").append(s2).toString());
            }
            fragment.p = true;
            if (!fragment.C)
            {
                fragment.a(this, attributeset, fragment.d);
            }
            b.b(fragment);
        }
        if (fragment.I == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(s2).append(" did not create a view.").toString());
        }
        if (i1 != 0)
        {
            fragment.I.setId(i1);
        }
        if (fragment.I.getTag() == null)
        {
            fragment.I.setTag(s3);
        }
        return fragment.I;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        a(false);
        b.r();
        if (m != null)
        {
            m.h();
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (android.os.Build.VERSION.SDK_INT < 5 && i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            onBackPressed();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        b.s();
    }

    public boolean onMenuItemSelected(int i1, MenuItem menuitem)
    {
        if (super.onMenuItemSelected(i1, menuitem))
        {
            return true;
        }
        switch (i1)
        {
        default:
            return false;

        case 0: // '\0'
            return b.a(menuitem);

        case 6: // '\006'
            return b.b(menuitem);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        b.i();
    }

    public void onPanelClosed(int i1, Menu menu)
    {
        i1;
        JVM INSTR tableswitch 0 0: default 20
    //                   0 27;
           goto _L1 _L2
_L1:
        super.onPanelClosed(i1, menu);
        return;
_L2:
        b.b(menu);
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onPause()
    {
        super.onPause();
        e = false;
        if (a.hasMessages(2))
        {
            a.removeMessages(2);
            a();
        }
        b.n();
    }

    protected void onPostResume()
    {
        super.onPostResume();
        a.removeMessages(2);
        a();
        b.e();
    }

    public boolean onPreparePanel(int i1, View view, Menu menu)
    {
        if (i1 == 0 && menu != null)
        {
            if (i)
            {
                i = false;
                menu.clear();
                onCreatePanelMenu(i1, menu);
            }
            boolean flag = super.onPreparePanel(i1, view, menu) | b.a(menu);
            boolean flag1 = false;
            if (flag)
            {
                boolean flag2 = menu.hasVisibleItems();
                flag1 = false;
                if (flag2)
                {
                    flag1 = true;
                }
            }
            return flag1;
        } else
        {
            return super.onPreparePanel(i1, view, menu);
        }
    }

    protected void onResume()
    {
        super.onResume();
        a.sendEmptyMessage(2);
        e = true;
        b.e();
    }

    public final Object onRetainNonConfigurationInstance()
    {
        if (f)
        {
            a(true);
        }
        Object obj = b();
        ArrayList arraylist = b.g();
        HashMap hashmap = l;
        int i1 = 0;
        if (hashmap != null)
        {
            ah aah[] = new ah[l.size()];
            l.values().toArray(aah);
            i1 = 0;
            if (aah != null)
            {
                boolean flag = false;
                while (i1 < aah.length) 
                {
                    ah ah1 = aah[i1];
                    if (ah1.g)
                    {
                        flag = true;
                    } else
                    {
                        ah1.h();
                        l.remove(ah1.d);
                    }
                    i1++;
                }
                i1 = ((flag) ? 1 : 0);
            }
        }
        if (arraylist == null && i1 == 0 && obj == null)
        {
            return null;
        } else
        {
            s s1 = new s();
            s1.a = null;
            s1.b = obj;
            s1.c = null;
            s1.d = arraylist;
            s1.e = l;
            return s1;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        android.os.Parcelable parcelable = b.h();
        if (parcelable != null)
        {
            bundle.putParcelable("android:support:fragments", parcelable);
        }
    }

    protected void onStart()
    {
        super.onStart();
        f = false;
        g = false;
        a.removeMessages(1);
        if (!d)
        {
            d = true;
            b.k();
        }
        b.i();
        b.e();
        if (k) goto _L2; else goto _L1
_L1:
        k = true;
        if (m == null) goto _L4; else goto _L3
_L3:
        m.b();
_L6:
        j = true;
_L2:
        b.l();
        if (l != null)
        {
            ah aah[] = new ah[l.size()];
            l.values().toArray(aah);
            int i1 = 0;
            if (aah != null)
            {
                for (; i1 < aah.length; i1++)
                {
                    ah ah1 = aah[i1];
                    ah1.e();
                    ah1.g();
                }

            }
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!j)
        {
            m = a(null, k, false);
            if (m != null && !m.f)
            {
                m.b();
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onStop()
    {
        super.onStop();
        f = true;
        a.sendEmptyMessage(1);
        b.o();
    }

    public void startActivityForResult(Intent intent, int i1)
    {
        if (i1 != -1 && (0xffff0000 & i1) != 0)
        {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else
        {
            super.startActivityForResult(intent, i1);
            return;
        }
    }
}
