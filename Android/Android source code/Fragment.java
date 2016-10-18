// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.b.a;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

// Referenced classes of package android.support.v4.app:
//            n, w, ak, ah, 
//            FragmentActivity, m

public class Fragment
    implements ComponentCallbacks, android.view.View.OnCreateContextMenuListener
{

    private static final HashMap P = new HashMap();
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    int G;
    ViewGroup H;
    View I;
    View J;
    boolean K;
    boolean L;
    ah M;
    boolean N;
    boolean O;
    int a;
    View b;
    int c;
    Bundle d;
    SparseArray e;
    int f;
    String g;
    Bundle h;
    Fragment i;
    int j;
    int k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    int r;
    w s;
    FragmentActivity t;
    w u;
    Fragment v;
    int w;
    int x;
    String y;
    boolean z;

    public Fragment()
    {
        a = 0;
        f = -1;
        j = -1;
        E = true;
        L = true;
    }

    public static Fragment a(Context context, String s1)
    {
        return a(context, s1, ((Bundle) (null)));
    }

    public static Fragment a(Context context, String s1, Bundle bundle)
    {
        Class class1;
        Fragment fragment;
        try
        {
            class1 = (Class)P.get(s1);
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            throw new n((new StringBuilder()).append("Unable to instantiate fragment ").append(s1).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), classnotfoundexception);
        }
        catch (InstantiationException instantiationexception)
        {
            throw new n((new StringBuilder()).append("Unable to instantiate fragment ").append(s1).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), instantiationexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new n((new StringBuilder()).append("Unable to instantiate fragment ").append(s1).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), illegalaccessexception);
        }
        if (class1 != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        class1 = context.getClassLoader().loadClass(s1);
        P.put(s1, class1);
        fragment = (Fragment)class1.newInstance();
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        bundle.setClassLoader(fragment.getClass().getClassLoader());
        fragment.h = bundle;
        return fragment;
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return null;
    }

    public Animation a(int i1, boolean flag, int j1)
    {
        return null;
    }

    public void a(int i1, int j1, Intent intent)
    {
    }

    final void a(int i1, Fragment fragment)
    {
        f = i1;
        if (fragment != null)
        {
            g = (new StringBuilder()).append(fragment.g).append(":").append(f).toString();
            return;
        } else
        {
            g = (new StringBuilder()).append("android:fragment:").append(f).toString();
            return;
        }
    }

    public void a(Activity activity)
    {
        F = true;
    }

    public void a(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        F = true;
    }

    void a(Configuration configuration)
    {
        onConfigurationChanged(configuration);
        if (u != null)
        {
            u.a(configuration);
        }
    }

    final void a(Bundle bundle)
    {
        if (e != null)
        {
            J.restoreHierarchyState(e);
            e = null;
        }
        F = false;
        e(bundle);
        if (!F)
        {
            throw new ak((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onViewStateRestored()").toString());
        } else
        {
            return;
        }
    }

    public void a(Menu menu)
    {
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(View view, Bundle bundle)
    {
    }

    public void a(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.print(s1);
        printwriter.print("mFragmentId=#");
        printwriter.print(Integer.toHexString(w));
        printwriter.print(" mContainerId=#");
        printwriter.print(Integer.toHexString(x));
        printwriter.print(" mTag=");
        printwriter.println(y);
        printwriter.print(s1);
        printwriter.print("mState=");
        printwriter.print(a);
        printwriter.print(" mIndex=");
        printwriter.print(f);
        printwriter.print(" mWho=");
        printwriter.print(g);
        printwriter.print(" mBackStackNesting=");
        printwriter.println(r);
        printwriter.print(s1);
        printwriter.print("mAdded=");
        printwriter.print(l);
        printwriter.print(" mRemoving=");
        printwriter.print(m);
        printwriter.print(" mResumed=");
        printwriter.print(n);
        printwriter.print(" mFromLayout=");
        printwriter.print(o);
        printwriter.print(" mInLayout=");
        printwriter.println(p);
        printwriter.print(s1);
        printwriter.print("mHidden=");
        printwriter.print(z);
        printwriter.print(" mDetached=");
        printwriter.print(A);
        printwriter.print(" mMenuVisible=");
        printwriter.print(E);
        printwriter.print(" mHasMenu=");
        printwriter.println(D);
        printwriter.print(s1);
        printwriter.print("mRetainInstance=");
        printwriter.print(B);
        printwriter.print(" mRetaining=");
        printwriter.print(C);
        printwriter.print(" mUserVisibleHint=");
        printwriter.println(L);
        if (s != null)
        {
            printwriter.print(s1);
            printwriter.print("mFragmentManager=");
            printwriter.println(s);
        }
        if (t != null)
        {
            printwriter.print(s1);
            printwriter.print("mActivity=");
            printwriter.println(t);
        }
        if (v != null)
        {
            printwriter.print(s1);
            printwriter.print("mParentFragment=");
            printwriter.println(v);
        }
        if (h != null)
        {
            printwriter.print(s1);
            printwriter.print("mArguments=");
            printwriter.println(h);
        }
        if (d != null)
        {
            printwriter.print(s1);
            printwriter.print("mSavedFragmentState=");
            printwriter.println(d);
        }
        if (e != null)
        {
            printwriter.print(s1);
            printwriter.print("mSavedViewState=");
            printwriter.println(e);
        }
        if (i != null)
        {
            printwriter.print(s1);
            printwriter.print("mTarget=");
            printwriter.print(i);
            printwriter.print(" mTargetRequestCode=");
            printwriter.println(k);
        }
        if (G != 0)
        {
            printwriter.print(s1);
            printwriter.print("mNextAnim=");
            printwriter.println(G);
        }
        if (H != null)
        {
            printwriter.print(s1);
            printwriter.print("mContainer=");
            printwriter.println(H);
        }
        if (I != null)
        {
            printwriter.print(s1);
            printwriter.print("mView=");
            printwriter.println(I);
        }
        if (J != null)
        {
            printwriter.print(s1);
            printwriter.print("mInnerView=");
            printwriter.println(I);
        }
        if (b != null)
        {
            printwriter.print(s1);
            printwriter.print("mAnimatingAway=");
            printwriter.println(b);
            printwriter.print(s1);
            printwriter.print("mStateAfterAnimating=");
            printwriter.println(c);
        }
        if (M != null)
        {
            printwriter.print(s1);
            printwriter.println("Loader Manager:");
            M.a((new StringBuilder()).append(s1).append("  ").toString(), filedescriptor, printwriter, as);
        }
        if (u != null)
        {
            printwriter.print(s1);
            printwriter.println((new StringBuilder()).append("Child ").append(u).append(":").toString());
            u.a((new StringBuilder()).append(s1).append("  ").toString(), filedescriptor, printwriter, as);
        }
    }

    public void a(boolean flag)
    {
    }

    final boolean a()
    {
        return r > 0;
    }

    public boolean a(MenuItem menuitem)
    {
        return false;
    }

    public final FragmentActivity b()
    {
        return t;
    }

    public LayoutInflater b(Bundle bundle)
    {
        return t.getLayoutInflater();
    }

    View b(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (u != null)
        {
            u.i();
        }
        return a(layoutinflater, viewgroup, bundle);
    }

    public void b(Menu menu)
    {
    }

    boolean b(Menu menu, MenuInflater menuinflater)
    {
        boolean flag = z;
        boolean flag1 = false;
        if (!flag)
        {
            boolean flag2 = D;
            flag1 = false;
            if (flag2)
            {
                boolean flag3 = E;
                flag1 = false;
                if (flag3)
                {
                    flag1 = true;
                    a(menu, menuinflater);
                }
            }
            if (u != null)
            {
                flag1 |= u.a(menu, menuinflater);
            }
        }
        return flag1;
    }

    public boolean b(MenuItem menuitem)
    {
        return false;
    }

    public final Resources c()
    {
        if (t == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(this).append(" not attached to Activity").toString());
        } else
        {
            return t.getResources();
        }
    }

    public void c(Bundle bundle)
    {
        F = true;
    }

    boolean c(Menu menu)
    {
        boolean flag = z;
        boolean flag1 = false;
        if (!flag)
        {
            boolean flag2 = D;
            flag1 = false;
            if (flag2)
            {
                boolean flag3 = E;
                flag1 = false;
                if (flag3)
                {
                    flag1 = true;
                    a(menu);
                }
            }
            if (u != null)
            {
                flag1 |= u.a(menu);
            }
        }
        return flag1;
    }

    boolean c(MenuItem menuitem)
    {
        while (!z && (D && E && a(menuitem) || u != null && u.a(menuitem))) 
        {
            return true;
        }
        return false;
    }

    public void d(Bundle bundle)
    {
        F = true;
    }

    void d(Menu menu)
    {
        if (!z)
        {
            if (D && E)
            {
                b(menu);
            }
            if (u != null)
            {
                u.b(menu);
            }
        }
    }

    public final boolean d()
    {
        return A;
    }

    boolean d(MenuItem menuitem)
    {
        while (!z && (b(menuitem) || u != null && u.b(menuitem))) 
        {
            return true;
        }
        return false;
    }

    public void e()
    {
        F = true;
        if (!N)
        {
            N = true;
            if (!O)
            {
                O = true;
                M = t.a(g, N, false);
            }
            if (M != null)
            {
                M.b();
            }
        }
    }

    public void e(Bundle bundle)
    {
        F = true;
    }

    public final boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    public void f()
    {
        F = true;
    }

    public void f(Bundle bundle)
    {
    }

    public void g()
    {
        F = true;
    }

    void g(Bundle bundle)
    {
        if (u != null)
        {
            u.i();
        }
        F = false;
        c(bundle);
        if (!F)
        {
            throw new ak((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onCreate()").toString());
        }
        if (bundle != null)
        {
            android.os.Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null)
            {
                if (u == null)
                {
                    n();
                }
                u.a(parcelable, null);
                u.j();
            }
        }
    }

    public void h()
    {
        F = true;
    }

    void h(Bundle bundle)
    {
        if (u != null)
        {
            u.i();
        }
        F = false;
        d(bundle);
        if (!F)
        {
            throw new ak((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onActivityCreated()").toString());
        }
        if (u != null)
        {
            u.k();
        }
    }

    public final int hashCode()
    {
        return super.hashCode();
    }

    public void i()
    {
        F = true;
    }

    void i(Bundle bundle)
    {
        f(bundle);
        if (u != null)
        {
            android.os.Parcelable parcelable = u.h();
            if (parcelable != null)
            {
                bundle.putParcelable("android:support:fragments", parcelable);
            }
        }
    }

    public void j()
    {
        F = true;
        if (!O)
        {
            O = true;
            M = t.a(g, N, false);
        }
        if (M != null)
        {
            M.h();
        }
    }

    void k()
    {
        f = -1;
        g = null;
        l = false;
        m = false;
        n = false;
        o = false;
        p = false;
        q = false;
        r = 0;
        s = null;
        t = null;
        w = 0;
        x = 0;
        y = null;
        z = false;
        A = false;
        C = false;
        M = null;
        N = false;
        O = false;
    }

    public void l()
    {
        F = true;
    }

    public void m()
    {
    }

    void n()
    {
        u = new w();
        u.a(t, new m(this), this);
    }

    void o()
    {
        if (u != null)
        {
            u.i();
            u.e();
        }
        F = false;
        e();
        if (!F)
        {
            throw new ak((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onStart()").toString());
        }
        if (u != null)
        {
            u.l();
        }
        if (M != null)
        {
            M.g();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        F = true;
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        b().onCreateContextMenu(contextmenu, view, contextmenuinfo);
    }

    public void onLowMemory()
    {
        F = true;
    }

    void p()
    {
        if (u != null)
        {
            u.i();
            u.e();
        }
        F = false;
        f();
        if (!F)
        {
            throw new ak((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onResume()").toString());
        }
        if (u != null)
        {
            u.m();
            u.e();
        }
    }

    void q()
    {
        onLowMemory();
        if (u != null)
        {
            u.s();
        }
    }

    void r()
    {
        if (u != null)
        {
            u.n();
        }
        F = false;
        g();
        if (!F)
        {
            throw new ak((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onPause()").toString());
        } else
        {
            return;
        }
    }

    void s()
    {
        if (u != null)
        {
            u.o();
        }
        F = false;
        h();
        if (!F)
        {
            throw new ak((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onStop()").toString());
        } else
        {
            return;
        }
    }

    void t()
    {
label0:
        {
            if (u != null)
            {
                u.p();
            }
            if (N)
            {
                N = false;
                if (!O)
                {
                    O = true;
                    M = t.a(g, N, false);
                }
                if (M != null)
                {
                    if (t.h)
                    {
                        break label0;
                    }
                    M.c();
                }
            }
            return;
        }
        M.d();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        android.support.v4.b.a.a(this, stringbuilder);
        if (f >= 0)
        {
            stringbuilder.append(" #");
            stringbuilder.append(f);
        }
        if (w != 0)
        {
            stringbuilder.append(" id=0x");
            stringbuilder.append(Integer.toHexString(w));
        }
        if (y != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append(y);
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    void u()
    {
        if (u != null)
        {
            u.q();
        }
        F = false;
        i();
        if (!F)
        {
            throw new ak((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onDestroyView()").toString());
        }
        if (M != null)
        {
            M.f();
        }
    }

    void v()
    {
        if (u != null)
        {
            u.r();
        }
        F = false;
        j();
        if (!F)
        {
            throw new ak((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onDestroy()").toString());
        } else
        {
            return;
        }
    }

}
