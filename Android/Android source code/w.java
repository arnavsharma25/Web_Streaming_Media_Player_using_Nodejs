// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.b.a;
import android.support.v4.b.b;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package android.support.v4.app:
//            u, x, FragmentActivity, Fragment, 
//            j, ah, FragmentManagerState, FragmentState, 
//            BackStackState, ak, aj, t, 
//            y, v, ae

final class w extends u
{

    static final Interpolator A = new DecelerateInterpolator(1.5F);
    static final Interpolator B = new AccelerateInterpolator(2.5F);
    static final Interpolator C = new AccelerateInterpolator(1.5F);
    static boolean a = false;
    static final boolean b;
    static final Interpolator z = new DecelerateInterpolator(2.5F);
    ArrayList c;
    Runnable d[];
    boolean e;
    ArrayList f;
    ArrayList g;
    ArrayList h;
    ArrayList i;
    ArrayList j;
    ArrayList k;
    ArrayList l;
    ArrayList m;
    int n;
    FragmentActivity o;
    t p;
    Fragment q;
    boolean r;
    boolean s;
    boolean t;
    String u;
    boolean v;
    Bundle w;
    SparseArray x;
    Runnable y;

    w()
    {
        n = 0;
        w = null;
        x = null;
        y = new x(this);
    }

    static Animation a(Context context, float f1, float f2)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(f1, f2);
        alphaanimation.setInterpolator(A);
        alphaanimation.setDuration(220L);
        return alphaanimation;
    }

    static Animation a(Context context, float f1, float f2, float f3, float f4)
    {
        AnimationSet animationset = new AnimationSet(false);
        ScaleAnimation scaleanimation = new ScaleAnimation(f1, f2, f1, f2, 1, 0.5F, 1, 0.5F);
        scaleanimation.setInterpolator(z);
        scaleanimation.setDuration(220L);
        animationset.addAnimation(scaleanimation);
        AlphaAnimation alphaanimation = new AlphaAnimation(f3, f4);
        alphaanimation.setInterpolator(A);
        alphaanimation.setDuration(220L);
        animationset.addAnimation(alphaanimation);
        return animationset;
    }

    private void a(RuntimeException runtimeexception)
    {
        Log.e("FragmentManager", runtimeexception.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printwriter = new PrintWriter(new b("FragmentManager"));
        if (o != null)
        {
            try
            {
                o.dump("  ", null, printwriter, new String[0]);
            }
            catch (Exception exception1)
            {
                Log.e("FragmentManager", "Failed dumping state", exception1);
            }
        } else
        {
            try
            {
                a("  ", ((FileDescriptor) (null)), printwriter, new String[0]);
            }
            catch (Exception exception)
            {
                Log.e("FragmentManager", "Failed dumping state", exception);
            }
        }
        throw runtimeexception;
    }

    public static int b(int i1, boolean flag)
    {
        switch (i1)
        {
        default:
            return -1;

        case 4097: 
            return !flag ? 2 : 1;

        case 8194: 
            return !flag ? 4 : 3;

        case 4099: 
            break;
        }
        return !flag ? 6 : 5;
    }

    public static int c(int i1)
    {
        switch (i1)
        {
        default:
            return 0;

        case 4097: 
            return 8194;

        case 8194: 
            return 4097;

        case 4099: 
            return 4099;
        }
    }

    private void t()
    {
        if (s)
        {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (u != null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Can not perform this action inside of ").append(u).toString());
        } else
        {
            return;
        }
    }

    public int a(j j1)
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        if (l != null && l.size() > 0)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if (k == null)
        {
            k = new ArrayList();
        }
        i1 = k.size();
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Setting back stack index ").append(i1).append(" to ").append(j1).toString());
        }
        k.add(j1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        int k1;
        k1 = ((Integer)l.remove(-1 + l.size())).intValue();
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Adding back stack index ").append(k1).append(" with ").append(j1).toString());
        }
        k.set(k1, j1);
        this;
        JVM INSTR monitorexit ;
        return k1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Fragment a(int i1)
    {
        if (g == null) goto _L2; else goto _L1
_L1:
        int k1 = -1 + g.size();
_L8:
        if (k1 < 0) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)g.get(k1);
        if (fragment == null || fragment.w != i1) goto _L5; else goto _L4
_L4:
        return fragment;
_L5:
        k1--;
        continue; /* Loop/switch isn't completed */
_L2:
label0:
        {
            if (f == null)
            {
                break label0;
            }
            int j1 = -1 + f.size();
            do
            {
                if (j1 < 0)
                {
                    break label0;
                }
                fragment = (Fragment)f.get(j1);
                if (fragment != null && fragment.w == i1)
                {
                    break;
                }
                j1--;
            } while (true);
        }
        if (true) goto _L4; else goto _L6
_L6:
        return null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public Fragment a(Bundle bundle, String s1)
    {
        int i1 = bundle.getInt(s1, -1);
        Fragment fragment;
        if (i1 == -1)
        {
            fragment = null;
        } else
        {
            if (i1 >= f.size())
            {
                a(((RuntimeException) (new IllegalStateException((new StringBuilder()).append("Fragement no longer exists for key ").append(s1).append(": index ").append(i1).toString()))));
            }
            fragment = (Fragment)f.get(i1);
            if (fragment == null)
            {
                a(((RuntimeException) (new IllegalStateException((new StringBuilder()).append("Fragement no longer exists for key ").append(s1).append(": index ").append(i1).toString()))));
                return fragment;
            }
        }
        return fragment;
    }

    public Fragment a(String s1)
    {
        if (g == null || s1 == null) goto _L2; else goto _L1
_L1:
        int j1 = -1 + g.size();
_L8:
        if (j1 < 0) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)g.get(j1);
        if (fragment == null || !s1.equals(fragment.y)) goto _L5; else goto _L4
_L4:
        return fragment;
_L5:
        j1--;
        continue; /* Loop/switch isn't completed */
_L2:
label0:
        {
            if (f == null || s1 == null)
            {
                break label0;
            }
            int i1 = -1 + f.size();
            do
            {
                if (i1 < 0)
                {
                    break label0;
                }
                fragment = (Fragment)f.get(i1);
                if (fragment != null && s1.equals(fragment.y))
                {
                    break;
                }
                i1--;
            } while (true);
        }
        if (true) goto _L4; else goto _L6
_L6:
        return null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public ae a()
    {
        return new j(this);
    }

    Animation a(Fragment fragment, int i1, boolean flag, int j1)
    {
        Animation animation = fragment.a(i1, flag, fragment.G);
        if (animation == null)
        {
            if (fragment.G == 0 || (animation = AnimationUtils.loadAnimation(o, fragment.G)) == null)
            {
                if (i1 == 0)
                {
                    return null;
                }
                int k1 = b(i1, flag);
                if (k1 < 0)
                {
                    return null;
                }
                switch (k1)
                {
                default:
                    if (j1 == 0 && o.getWindow() != null)
                    {
                        j1 = o.getWindow().getAttributes().windowAnimations;
                    }
                    if (j1 == 0)
                    {
                        return null;
                    } else
                    {
                        return null;
                    }

                case 1: // '\001'
                    return a(((Context) (o)), 1.125F, 1.0F, 0.0F, 1.0F);

                case 2: // '\002'
                    return a(((Context) (o)), 1.0F, 0.975F, 1.0F, 0.0F);

                case 3: // '\003'
                    return a(((Context) (o)), 0.975F, 1.0F, 0.0F, 1.0F);

                case 4: // '\004'
                    return a(((Context) (o)), 1.0F, 1.075F, 1.0F, 0.0F);

                case 5: // '\005'
                    return a(((Context) (o)), 0.0F, 1.0F);

                case 6: // '\006'
                    return a(((Context) (o)), 1.0F, 0.0F);
                }
            }
        }
        return animation;
    }

    void a(int i1, int j1, int k1, boolean flag)
    {
        if (o == null && i1 != 0)
        {
            throw new IllegalStateException("No activity");
        }
        if (flag || n != i1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        n = i1;
        if (f == null) goto _L1; else goto _L3
_L3:
        int l1;
        boolean flag1;
        l1 = 0;
        flag1 = false;
_L5:
        boolean flag2;
        if (l1 >= f.size())
        {
            break; /* Loop/switch isn't completed */
        }
        Fragment fragment = (Fragment)f.get(l1);
        if (fragment == null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        a(fragment, i1, j1, k1, false);
        if (fragment.M == null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        flag2 = flag1 | fragment.M.a();
_L6:
        l1++;
        flag1 = flag2;
        if (true) goto _L5; else goto _L4
_L4:
        if (!flag1)
        {
            d();
        }
        if (r && o != null && n == 5)
        {
            o.c();
            r = false;
            return;
        }
          goto _L1
        flag2 = flag1;
          goto _L6
    }

    public void a(int i1, j j1)
    {
        this;
        JVM INSTR monitorenter ;
        int k1;
        if (k == null)
        {
            k = new ArrayList();
        }
        k1 = k.size();
        if (i1 >= k1) goto _L2; else goto _L1
_L1:
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Setting back stack index ").append(i1).append(" to ").append(j1).toString());
        }
        k.set(i1, j1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (k1 >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        k.add(null);
        if (l == null)
        {
            l = new ArrayList();
        }
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Adding available back stack index ").append(k1).toString());
        }
        l.add(Integer.valueOf(k1));
        k1++;
        if (true) goto _L2; else goto _L3
_L3:
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Adding back stack index ").append(i1).append(" with ").append(j1).toString());
        }
        k.add(j1);
          goto _L4
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void a(int i1, boolean flag)
    {
        a(i1, 0, 0, flag);
    }

    public void a(Configuration configuration)
    {
        if (g != null)
        {
            for (int i1 = 0; i1 < g.size(); i1++)
            {
                Fragment fragment = (Fragment)g.get(i1);
                if (fragment != null)
                {
                    fragment.a(configuration);
                }
            }

        }
    }

    public void a(Bundle bundle, String s1, Fragment fragment)
    {
        if (fragment.f < 0)
        {
            a(((RuntimeException) (new IllegalStateException((new StringBuilder()).append("Fragment ").append(fragment).append(" is not currently in the FragmentManager").toString()))));
        }
        bundle.putInt(s1, fragment.f);
    }

    void a(Parcelable parcelable, ArrayList arraylist)
    {
        if (parcelable != null) goto _L2; else goto _L1
_L1:
        FragmentManagerState fragmentmanagerstate;
        return;
_L2:
        if ((fragmentmanagerstate = (FragmentManagerState)parcelable).a != null)
        {
            if (arraylist != null)
            {
                for (int i2 = 0; i2 < arraylist.size(); i2++)
                {
                    Fragment fragment3 = (Fragment)arraylist.get(i2);
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: re-attaching retained ").append(fragment3).toString());
                    }
                    FragmentState fragmentstate1 = fragmentmanagerstate.a[fragment3.f];
                    fragmentstate1.k = fragment3;
                    fragment3.e = null;
                    fragment3.r = 0;
                    fragment3.p = false;
                    fragment3.l = false;
                    fragment3.i = null;
                    if (fragmentstate1.j != null)
                    {
                        fragmentstate1.j.setClassLoader(o.getClassLoader());
                        fragment3.e = fragmentstate1.j.getSparseParcelableArray("android:view_state");
                    }
                }

            }
            f = new ArrayList(fragmentmanagerstate.a.length);
            if (h != null)
            {
                h.clear();
            }
            int i1 = 0;
            while (i1 < fragmentmanagerstate.a.length) 
            {
                FragmentState fragmentstate = fragmentmanagerstate.a[i1];
                if (fragmentstate != null)
                {
                    Fragment fragment2 = fragmentstate.a(o, q);
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: active #").append(i1).append(": ").append(fragment2).toString());
                    }
                    f.add(fragment2);
                    fragmentstate.k = null;
                } else
                {
                    f.add(null);
                    if (h == null)
                    {
                        h = new ArrayList();
                    }
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: avail #").append(i1).toString());
                    }
                    h.add(Integer.valueOf(i1));
                }
                i1++;
            }
            if (arraylist != null)
            {
                int l1 = 0;
                while (l1 < arraylist.size()) 
                {
                    Fragment fragment1 = (Fragment)arraylist.get(l1);
                    if (fragment1.j >= 0)
                    {
                        if (fragment1.j < f.size())
                        {
                            fragment1.i = (Fragment)f.get(fragment1.j);
                        } else
                        {
                            Log.w("FragmentManager", (new StringBuilder()).append("Re-attaching retained fragment ").append(fragment1).append(" target no longer exists: ").append(fragment1.j).toString());
                            fragment1.i = null;
                        }
                    }
                    l1++;
                }
            }
            if (fragmentmanagerstate.b != null)
            {
                g = new ArrayList(fragmentmanagerstate.b.length);
                for (int k1 = 0; k1 < fragmentmanagerstate.b.length; k1++)
                {
                    Fragment fragment = (Fragment)f.get(fragmentmanagerstate.b[k1]);
                    if (fragment == null)
                    {
                        a(((RuntimeException) (new IllegalStateException((new StringBuilder()).append("No instantiated fragment for index #").append(fragmentmanagerstate.b[k1]).toString()))));
                    }
                    fragment.l = true;
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: added #").append(k1).append(": ").append(fragment).toString());
                    }
                    if (g.contains(fragment))
                    {
                        throw new IllegalStateException("Already added!");
                    }
                    g.add(fragment);
                }

            } else
            {
                g = null;
            }
            if (fragmentmanagerstate.c != null)
            {
                i = new ArrayList(fragmentmanagerstate.c.length);
                int j1 = 0;
                while (j1 < fragmentmanagerstate.c.length) 
                {
                    j j2 = fragmentmanagerstate.c[j1].a(this);
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: back stack #").append(j1).append(" (index ").append(j2.o).append("): ").append(j2).toString());
                        j2.a("  ", new PrintWriter(new b("FragmentManager")), false);
                    }
                    i.add(j2);
                    if (j2.o >= 0)
                    {
                        a(j2.o, j2);
                    }
                    j1++;
                }
            } else
            {
                i = null;
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void a(Fragment fragment)
    {
label0:
        {
            if (fragment.K)
            {
                if (!e)
                {
                    break label0;
                }
                v = true;
            }
            return;
        }
        fragment.K = false;
        a(fragment, n, 0, 0, false);
    }

    public void a(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("remove: ").append(fragment).append(" nesting=").append(fragment.r).toString());
        }
        boolean flag;
        if (!fragment.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!fragment.A || flag)
        {
            if (g != null)
            {
                g.remove(fragment);
            }
            if (fragment.D && fragment.E)
            {
                r = true;
            }
            fragment.l = false;
            fragment.m = true;
            int k1;
            if (flag)
            {
                k1 = 0;
            } else
            {
                k1 = 1;
            }
            a(fragment, k1, i1, j1, false);
        }
    }

    void a(Fragment fragment, int i1, int j1, int k1, boolean flag)
    {
        if ((!fragment.l || fragment.A) && i1 > 1)
        {
            i1 = 1;
        }
        if (fragment.m && i1 > fragment.a)
        {
            i1 = fragment.a;
        }
        if (fragment.K && fragment.a < 4 && i1 > 3)
        {
            i1 = 3;
        }
        if (fragment.a >= i1) goto _L2; else goto _L1
_L1:
        if (fragment.o && !fragment.p)
        {
            return;
        }
        if (fragment.b != null)
        {
            fragment.b = null;
            a(fragment, fragment.c, 0, 0, true);
        }
        fragment.a;
        JVM INSTR tableswitch 0 4: default 148
    //                   0 154
    //                   1 499
    //                   2 796
    //                   3 796
    //                   4 837;
           goto _L3 _L4 _L5 _L6 _L6 _L7
_L3:
        fragment.a = i1;
        return;
_L4:
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("moveto CREATED: ").append(fragment).toString());
        }
        if (fragment.d != null)
        {
            fragment.e = fragment.d.getSparseParcelableArray("android:view_state");
            fragment.i = a(fragment.d, "android:target_state");
            if (fragment.i != null)
            {
                fragment.k = fragment.d.getInt("android:target_req_state", 0);
            }
            fragment.L = fragment.d.getBoolean("android:user_visible_hint", true);
            if (!fragment.L)
            {
                fragment.K = true;
                if (i1 > 3)
                {
                    i1 = 3;
                }
            }
        }
        fragment.t = o;
        fragment.v = q;
        w w1;
        if (q != null)
        {
            w1 = q.u;
        } else
        {
            w1 = o.b;
        }
        fragment.s = w1;
        fragment.F = false;
        fragment.a(o);
        if (!fragment.F)
        {
            throw new ak((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onAttach()").toString());
        }
        if (fragment.v == null)
        {
            o.a(fragment);
        }
        if (!fragment.C)
        {
            fragment.g(fragment.d);
        }
        fragment.C = false;
        if (fragment.o)
        {
            fragment.I = fragment.b(fragment.b(fragment.d), null, fragment.d);
            Animation animation1;
            if (fragment.I != null)
            {
                fragment.J = fragment.I;
                fragment.I = android.support.v4.app.aj.a(fragment.I);
                if (fragment.z)
                {
                    fragment.I.setVisibility(8);
                }
                fragment.a(fragment.I, fragment.d);
            } else
            {
                fragment.J = null;
            }
        }
_L5:
        if (i1 > 1)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("moveto ACTIVITY_CREATED: ").append(fragment).toString());
            }
            if (!fragment.o)
            {
                View view;
                Animation animation;
                ViewGroup viewgroup;
                if (fragment.x != 0)
                {
                    viewgroup = (ViewGroup)p.a(fragment.x);
                    if (viewgroup == null && !fragment.q)
                    {
                        a(((RuntimeException) (new IllegalArgumentException((new StringBuilder()).append("No view found for id 0x").append(Integer.toHexString(fragment.x)).append(" (").append(fragment.c().getResourceName(fragment.x)).append(") for fragment ").append(fragment).toString()))));
                    }
                } else
                {
                    viewgroup = null;
                }
                fragment.H = viewgroup;
                fragment.I = fragment.b(fragment.b(fragment.d), viewgroup, fragment.d);
                if (fragment.I != null)
                {
                    fragment.J = fragment.I;
                    fragment.I = android.support.v4.app.aj.a(fragment.I);
                    if (viewgroup != null)
                    {
                        animation1 = a(fragment, j1, true, k1);
                        if (animation1 != null)
                        {
                            fragment.I.startAnimation(animation1);
                        }
                        viewgroup.addView(fragment.I);
                    }
                    if (fragment.z)
                    {
                        fragment.I.setVisibility(8);
                    }
                    fragment.a(fragment.I, fragment.d);
                } else
                {
                    fragment.J = null;
                }
            }
            fragment.h(fragment.d);
            if (fragment.I != null)
            {
                fragment.a(fragment.d);
            }
            fragment.d = null;
        }
_L6:
        if (i1 > 3)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("moveto STARTED: ").append(fragment).toString());
            }
            fragment.o();
        }
_L7:
        if (i1 > 4)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("moveto RESUMED: ").append(fragment).toString());
            }
            fragment.n = true;
            fragment.p();
            fragment.d = null;
            fragment.e = null;
        }
          goto _L8
_L2:
        if (fragment.a <= i1) goto _L8; else goto _L9
_L9:
        fragment.a;
        JVM INSTR tableswitch 1 5: default 960
    //                   1 963
    //                   2 1143
    //                   3 1102
    //                   4 1061
    //                   5 1015;
           goto _L10 _L11 _L12 _L13 _L14 _L15
_L10:
        break; /* Loop/switch isn't completed */
_L11:
        if (i1 < 1)
        {
            if (t && fragment.b != null)
            {
                view = fragment.b;
                fragment.b = null;
                view.clearAnimation();
            }
            if (fragment.b != null)
            {
                fragment.c = i1;
                i1 = 1;
            } else
            {
                if (a)
                {
                    Log.v("FragmentManager", (new StringBuilder()).append("movefrom CREATED: ").append(fragment).toString());
                }
                if (!fragment.C)
                {
                    fragment.v();
                }
                fragment.F = false;
                fragment.l();
                if (!fragment.F)
                {
                    throw new ak((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onDetach()").toString());
                }
                if (!flag)
                {
                    if (!fragment.C)
                    {
                        d(fragment);
                    } else
                    {
                        fragment.t = null;
                        fragment.s = null;
                    }
                }
            }
        }
        break; /* Loop/switch isn't completed */
_L15:
        if (i1 < 5)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom RESUMED: ").append(fragment).toString());
            }
            fragment.r();
            fragment.n = false;
        }
_L14:
        if (i1 < 4)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom STARTED: ").append(fragment).toString());
            }
            fragment.s();
        }
_L13:
        if (i1 < 3)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom STOPPED: ").append(fragment).toString());
            }
            fragment.t();
        }
_L12:
        if (i1 < 2)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom ACTIVITY_CREATED: ").append(fragment).toString());
            }
            if (fragment.I != null && !o.isFinishing() && fragment.e == null)
            {
                e(fragment);
            }
            fragment.u();
            if (fragment.I != null && fragment.H != null)
            {
                if (n > 0 && !t)
                {
                    animation = a(fragment, j1, false, k1);
                } else
                {
                    animation = null;
                }
                if (animation != null)
                {
                    fragment.b = fragment.I;
                    fragment.c = i1;
                    animation.setAnimationListener(new y(this, fragment));
                    fragment.I.startAnimation(animation);
                }
                fragment.H.removeView(fragment.I);
            }
            fragment.H = null;
            fragment.I = null;
            fragment.J = null;
        }
        if (true) goto _L11; else goto _L8
_L8:
        if (true) goto _L3; else goto _L16
_L16:
    }

    public void a(Fragment fragment, boolean flag)
    {
        if (g == null)
        {
            g = new ArrayList();
        }
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("add: ").append(fragment).toString());
        }
        c(fragment);
        if (!fragment.A)
        {
            if (g.contains(fragment))
            {
                throw new IllegalStateException((new StringBuilder()).append("Fragment already added: ").append(fragment).toString());
            }
            g.add(fragment);
            fragment.l = true;
            fragment.m = false;
            if (fragment.D && fragment.E)
            {
                r = true;
            }
            if (flag)
            {
                b(fragment);
            }
        }
    }

    public void a(FragmentActivity fragmentactivity, t t1, Fragment fragment)
    {
        if (o != null)
        {
            throw new IllegalStateException("Already attached");
        } else
        {
            o = fragmentactivity;
            p = t1;
            q = fragment;
            return;
        }
    }

    public void a(Runnable runnable, boolean flag)
    {
        if (!flag)
        {
            t();
        }
        this;
        JVM INSTR monitorenter ;
        if (o == null)
        {
            throw new IllegalStateException("Activity has been destroyed");
        }
        break MISSING_BLOCK_LABEL_33;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (c == null)
        {
            c = new ArrayList();
        }
        c.add(runnable);
        if (c.size() == 1)
        {
            o.a.removeCallbacks(y);
            o.a.post(y);
        }
        this;
        JVM INSTR monitorexit ;
    }

    public void a(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        int i1;
        i1 = 0;
        String s2 = (new StringBuilder()).append(s1).append("    ").toString();
        if (f != null)
        {
            int i4 = f.size();
            if (i4 > 0)
            {
                printwriter.print(s1);
                printwriter.print("Active Fragments in ");
                printwriter.print(Integer.toHexString(System.identityHashCode(this)));
                printwriter.println(":");
                for (int j4 = 0; j4 < i4; j4++)
                {
                    Fragment fragment2 = (Fragment)f.get(j4);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(j4);
                    printwriter.print(": ");
                    printwriter.println(fragment2);
                    if (fragment2 != null)
                    {
                        fragment2.a(s2, filedescriptor, printwriter, as);
                    }
                }

            }
        }
        if (g != null)
        {
            int k3 = g.size();
            if (k3 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Added Fragments:");
                for (int l3 = 0; l3 < k3; l3++)
                {
                    Fragment fragment1 = (Fragment)g.get(l3);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(l3);
                    printwriter.print(": ");
                    printwriter.println(fragment1.toString());
                }

            }
        }
        if (j != null)
        {
            int l2 = j.size();
            if (l2 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Fragments Created Menus:");
                for (int i3 = 0; i3 < l2; i3++)
                {
                    Fragment fragment = (Fragment)j.get(i3);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(i3);
                    printwriter.print(": ");
                    printwriter.println(fragment.toString());
                }

            }
        }
        if (i != null)
        {
            int i2 = i.size();
            if (i2 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Back Stack:");
                for (int k2 = 0; k2 < i2; k2++)
                {
                    j j3 = (j)i.get(k2);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(k2);
                    printwriter.print(": ");
                    printwriter.println(j3.toString());
                    j3.a(s2, filedescriptor, printwriter, as);
                }

            }
        }
        this;
        JVM INSTR monitorenter ;
        if (k == null) goto _L2; else goto _L1
_L1:
        int k1 = k.size();
        if (k1 <= 0) goto _L2; else goto _L3
_L3:
        printwriter.print(s1);
        printwriter.println("Back Stack Indices:");
        int l1 = 0;
_L4:
        if (l1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        j j2 = (j)k.get(l1);
        printwriter.print(s1);
        printwriter.print("  #");
        printwriter.print(l1);
        printwriter.print(": ");
        printwriter.println(j2);
        l1++;
        if (true) goto _L4; else goto _L2
_L2:
        if (l != null && l.size() > 0)
        {
            printwriter.print(s1);
            printwriter.print("mAvailBackStackIndices: ");
            printwriter.println(Arrays.toString(l.toArray()));
        }
        this;
        JVM INSTR monitorexit ;
        if (c != null)
        {
            int j1 = c.size();
            if (j1 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Pending Actions:");
                for (; i1 < j1; i1++)
                {
                    Runnable runnable = (Runnable)c.get(i1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(i1);
                    printwriter.print(": ");
                    printwriter.println(runnable);
                }

            }
        }
        break MISSING_BLOCK_LABEL_694;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        printwriter.print(s1);
        printwriter.println("FragmentManager misc state:");
        printwriter.print(s1);
        printwriter.print("  mActivity=");
        printwriter.println(o);
        printwriter.print(s1);
        printwriter.print("  mContainer=");
        printwriter.println(p);
        if (q != null)
        {
            printwriter.print(s1);
            printwriter.print("  mParent=");
            printwriter.println(q);
        }
        printwriter.print(s1);
        printwriter.print("  mCurState=");
        printwriter.print(n);
        printwriter.print(" mStateSaved=");
        printwriter.print(s);
        printwriter.print(" mDestroyed=");
        printwriter.println(t);
        if (r)
        {
            printwriter.print(s1);
            printwriter.print("  mNeedMenuInvalidate=");
            printwriter.println(r);
        }
        if (u != null)
        {
            printwriter.print(s1);
            printwriter.print("  mNoTransactionsBecause=");
            printwriter.println(u);
        }
        if (h != null && h.size() > 0)
        {
            printwriter.print(s1);
            printwriter.print("  mAvailIndices: ");
            printwriter.println(Arrays.toString(h.toArray()));
        }
        return;
    }

    boolean a(Handler handler, String s1, int i1, int j1)
    {
        if (i != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int l2;
        if (s1 != null || i1 >= 0 || (j1 & 1) != 0) goto _L4; else goto _L3
_L3:
        if ((l2 = -1 + i.size()) < 0) goto _L1; else goto _L5
_L5:
        ((j)i.remove(l2)).b(true);
        f();
_L8:
        return true;
_L4:
        int k1;
        int l1;
        k1 = -1;
        if (s1 == null && i1 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = -1 + i.size();
        break MISSING_BLOCK_LABEL_84;
        if (l1 < 0) goto _L1; else goto _L6
_L6:
        if ((j1 & 1) != 0)
        {
            l1--;
            do
            {
                if (l1 < 0)
                {
                    break;
                }
                j j4 = (j)i.get(l1);
                if ((s1 == null || !s1.equals(j4.b())) && (i1 < 0 || i1 != j4.o))
                {
                    break;
                }
                l1--;
            } while (true);
        }
        break MISSING_BLOCK_LABEL_207;
        do
        {
            {
                if (l1 < 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                j j5 = (j)i.get(l1);
                if (s1 != null && s1.equals(j5.b()) || i1 >= 0 && i1 == j5.o)
                {
                    continue; /* Loop/switch isn't completed */
                }
                l1--;
            }
        } while (true);
        k1 = l1;
        if (k1 == -1 + i.size()) goto _L1; else goto _L7
_L7:
        ArrayList arraylist = new ArrayList();
        for (int i2 = -1 + i.size(); i2 > k1; i2--)
        {
            arraylist.add(i.remove(i2));
        }

        int j2 = -1 + arraylist.size();
        int k2 = 0;
        while (k2 <= j2) 
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("Popping back stack state: ").append(arraylist.get(k2)).toString());
            }
            j j3 = (j)arraylist.get(k2);
            boolean flag;
            if (k2 == j2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            j3.b(flag);
            k2++;
        }
        f();
          goto _L8
    }

    public boolean a(Menu menu)
    {
        boolean flag;
        if (g != null)
        {
            int i1 = 0;
            flag = false;
            for (; i1 < g.size(); i1++)
            {
                Fragment fragment = (Fragment)g.get(i1);
                if (fragment != null && fragment.c(menu))
                {
                    flag = true;
                }
            }

        } else
        {
            flag = false;
        }
        return flag;
    }

    public boolean a(Menu menu, MenuInflater menuinflater)
    {
        ArrayList arraylist = null;
        boolean flag;
        if (g != null)
        {
            int j1 = 0;
            boolean flag1;
            for (flag = false; j1 < g.size(); flag = flag1)
            {
                Fragment fragment1 = (Fragment)g.get(j1);
                if (fragment1 != null && fragment1.b(menu, menuinflater))
                {
                    flag = true;
                    if (arraylist == null)
                    {
                        arraylist = new ArrayList();
                    }
                    arraylist.add(fragment1);
                }
                flag1 = flag;
                j1++;
            }

        } else
        {
            flag = false;
        }
        ArrayList arraylist1 = j;
        int i1 = 0;
        if (arraylist1 != null)
        {
            for (; i1 < j.size(); i1++)
            {
                Fragment fragment = (Fragment)j.get(i1);
                if (arraylist == null || !arraylist.contains(fragment))
                {
                    fragment.m();
                }
            }

        }
        j = arraylist;
        return flag;
    }

    public boolean a(MenuItem menuitem)
    {
        ArrayList arraylist;
        boolean flag;
        arraylist = g;
        flag = false;
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        int j1;
        j1 = g.size();
        flag = false;
        if (i1 >= j1) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)g.get(i1);
        if (fragment == null || !fragment.c(menuitem)) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void b(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        k.set(i1, null);
        if (l == null)
        {
            l = new ArrayList();
        }
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Freeing back stack index ").append(i1).toString());
        }
        l.add(Integer.valueOf(i1));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void b(Fragment fragment)
    {
        a(fragment, n, 0, 0, false);
    }

    public void b(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("hide: ").append(fragment).toString());
        }
        if (!fragment.z)
        {
            fragment.z = true;
            if (fragment.I != null)
            {
                Animation animation = a(fragment, i1, true, j1);
                if (animation != null)
                {
                    fragment.I.startAnimation(animation);
                }
                fragment.I.setVisibility(8);
            }
            if (fragment.l && fragment.D && fragment.E)
            {
                r = true;
            }
            fragment.a(true);
        }
    }

    void b(j j1)
    {
        if (i == null)
        {
            i = new ArrayList();
        }
        i.add(j1);
        f();
    }

    public void b(Menu menu)
    {
        if (g != null)
        {
            for (int i1 = 0; i1 < g.size(); i1++)
            {
                Fragment fragment = (Fragment)g.get(i1);
                if (fragment != null)
                {
                    fragment.d(menu);
                }
            }

        }
    }

    public boolean b()
    {
        return e();
    }

    public boolean b(MenuItem menuitem)
    {
        ArrayList arraylist;
        boolean flag;
        arraylist = g;
        flag = false;
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        int j1;
        j1 = g.size();
        flag = false;
        if (i1 >= j1) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)g.get(i1);
        if (fragment == null || !fragment.d(menuitem)) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    void c(Fragment fragment)
    {
        if (fragment.f < 0)
        {
            if (h == null || h.size() <= 0)
            {
                if (f == null)
                {
                    f = new ArrayList();
                }
                fragment.a(f.size(), q);
                f.add(fragment);
            } else
            {
                fragment.a(((Integer)h.remove(-1 + h.size())).intValue(), q);
                f.set(fragment.f, fragment);
            }
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("Allocated fragment index ").append(fragment).toString());
                return;
            }
        }
    }

    public void c(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("show: ").append(fragment).toString());
        }
        if (fragment.z)
        {
            fragment.z = false;
            if (fragment.I != null)
            {
                Animation animation = a(fragment, i1, true, j1);
                if (animation != null)
                {
                    fragment.I.startAnimation(animation);
                }
                fragment.I.setVisibility(0);
            }
            if (fragment.l && fragment.D && fragment.E)
            {
                r = true;
            }
            fragment.a(false);
        }
    }

    public boolean c()
    {
        t();
        b();
        return a(o.a, ((String) (null)), -1, 0);
    }

    void d()
    {
        if (f != null)
        {
            int i1 = 0;
            while (i1 < f.size()) 
            {
                Fragment fragment = (Fragment)f.get(i1);
                if (fragment != null)
                {
                    a(fragment);
                }
                i1++;
            }
        }
    }

    void d(Fragment fragment)
    {
        if (fragment.f < 0)
        {
            return;
        }
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Freeing fragment index ").append(fragment).toString());
        }
        f.set(fragment.f, null);
        if (h == null)
        {
            h = new ArrayList();
        }
        h.add(Integer.valueOf(fragment.f));
        o.a(fragment.g);
        fragment.k();
    }

    public void d(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("detach: ").append(fragment).toString());
        }
        if (!fragment.A)
        {
            fragment.A = true;
            if (fragment.l)
            {
                if (g != null)
                {
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("remove from detach: ").append(fragment).toString());
                    }
                    g.remove(fragment);
                }
                if (fragment.D && fragment.E)
                {
                    r = true;
                }
                fragment.l = false;
                a(fragment, 1, i1, j1, false);
            }
        }
    }

    void e(Fragment fragment)
    {
        if (fragment.J != null)
        {
            if (x == null)
            {
                x = new SparseArray();
            } else
            {
                x.clear();
            }
            fragment.J.saveHierarchyState(x);
            if (x.size() > 0)
            {
                fragment.e = x;
                x = null;
                return;
            }
        }
    }

    public void e(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("attach: ").append(fragment).toString());
        }
        if (fragment.A)
        {
            fragment.A = false;
            if (!fragment.l)
            {
                if (g == null)
                {
                    g = new ArrayList();
                }
                if (g.contains(fragment))
                {
                    throw new IllegalStateException((new StringBuilder()).append("Fragment already added: ").append(fragment).toString());
                }
                if (a)
                {
                    Log.v("FragmentManager", (new StringBuilder()).append("add from attach: ").append(fragment).toString());
                }
                g.add(fragment);
                fragment.l = true;
                if (fragment.D && fragment.E)
                {
                    r = true;
                }
                a(fragment, n, i1, j1, false);
            }
        }
    }

    public boolean e()
    {
        if (e)
        {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        if (Looper.myLooper() != o.a.getLooper())
        {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        boolean flag = false;
_L2:
        this;
        JVM INSTR monitorenter ;
        if (c != null && c.size() != 0)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        this;
        JVM INSTR monitorexit ;
        boolean flag1;
        if (!v)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        int i1 = 0;
        flag1 = false;
        for (; i1 < f.size(); i1++)
        {
            Fragment fragment = (Fragment)f.get(i1);
            if (fragment != null && fragment.M != null)
            {
                flag1 |= fragment.M.a();
            }
        }

        break; /* Loop/switch isn't completed */
        int j1;
        j1 = c.size();
        if (d == null || d.length < j1)
        {
            d = new Runnable[j1];
        }
        c.toArray(d);
        c.clear();
        o.a.removeCallbacks(y);
        this;
        JVM INSTR monitorexit ;
        e = true;
        for (int k1 = 0; k1 < j1; k1++)
        {
            d[k1].run();
            d[k1] = null;
        }

        break MISSING_BLOCK_LABEL_252;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        e = false;
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
        if (!flag1)
        {
            v = false;
            d();
        }
        return flag;
    }

    Bundle f(Fragment fragment)
    {
        if (w == null)
        {
            w = new Bundle();
        }
        fragment.i(w);
        Bundle bundle;
        if (!w.isEmpty())
        {
            bundle = w;
            w = null;
        } else
        {
            bundle = null;
        }
        if (fragment.I != null)
        {
            e(fragment);
        }
        if (fragment.e != null)
        {
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.e);
        }
        if (!fragment.L)
        {
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.L);
        }
        return bundle;
    }

    void f()
    {
        if (m != null)
        {
            for (int i1 = 0; i1 < m.size(); i1++)
            {
                ((v)m.get(i1)).a();
            }

        }
    }

    ArrayList g()
    {
        ArrayList arraylist = f;
        ArrayList arraylist1 = null;
        if (arraylist != null)
        {
            int i1 = 0;
            while (i1 < f.size()) 
            {
                Fragment fragment = (Fragment)f.get(i1);
                if (fragment == null || !fragment.B)
                {
                    continue;
                }
                if (arraylist1 == null)
                {
                    arraylist1 = new ArrayList();
                }
                arraylist1.add(fragment);
                fragment.C = true;
                int j1;
                if (fragment.i != null)
                {
                    j1 = fragment.i.f;
                } else
                {
                    j1 = -1;
                }
                fragment.j = j1;
                if (a)
                {
                    Log.v("FragmentManager", (new StringBuilder()).append("retainNonConfig: keeping retained ").append(fragment).toString());
                }
                i1++;
            }
        }
        return arraylist1;
    }

    Parcelable h()
    {
        e();
        if (b)
        {
            s = true;
        }
        if (f != null && f.size() > 0) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        int i1 = f.size();
        FragmentState afragmentstate[] = new FragmentState[i1];
        int j1 = 0;
        boolean flag = false;
        while (j1 < i1) 
        {
            Fragment fragment = (Fragment)f.get(j1);
            int ai[];
            ArrayList arraylist;
            BackStackState abackstackstate[];
            FragmentManagerState fragmentmanagerstate;
            int k1;
            int l1;
            int i2;
            int j2;
            boolean flag1;
            if (fragment != null)
            {
                if (fragment.f < 0)
                {
                    a(new IllegalStateException((new StringBuilder()).append("Failure saving state: active ").append(fragment).append(" has cleared index: ").append(fragment.f).toString()));
                }
                FragmentState fragmentstate = new FragmentState(fragment);
                afragmentstate[j1] = fragmentstate;
                if (fragment.a > 0 && fragmentstate.j == null)
                {
                    fragmentstate.j = f(fragment);
                    if (fragment.i != null)
                    {
                        if (fragment.i.f < 0)
                        {
                            a(new IllegalStateException((new StringBuilder()).append("Failure saving state: ").append(fragment).append(" has target not in fragment manager: ").append(fragment.i).toString()));
                        }
                        if (fragmentstate.j == null)
                        {
                            fragmentstate.j = new Bundle();
                        }
                        a(fragmentstate.j, "android:target_state", fragment.i);
                        if (fragment.k != 0)
                        {
                            fragmentstate.j.putInt("android:target_req_state", fragment.k);
                        }
                    }
                } else
                {
                    fragmentstate.j = fragment.d;
                }
                if (a)
                {
                    Log.v("FragmentManager", (new StringBuilder()).append("Saved state of ").append(fragment).append(": ").append(fragmentstate.j).toString());
                }
                flag1 = true;
            } else
            {
                flag1 = flag;
            }
            j1++;
            flag = flag1;
        }
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a)
        {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
        if (true) goto _L1; else goto _L3
_L3:
label0:
        {
            if (g != null)
            {
                i2 = g.size();
                if (i2 > 0)
                {
                    ai = new int[i2];
                    for (j2 = 0; j2 < i2; j2++)
                    {
                        ai[j2] = ((Fragment)g.get(j2)).f;
                        if (ai[j2] < 0)
                        {
                            a(new IllegalStateException((new StringBuilder()).append("Failure saving state: active ").append(g.get(j2)).append(" has cleared index: ").append(ai[j2]).toString()));
                        }
                        if (a)
                        {
                            Log.v("FragmentManager", (new StringBuilder()).append("saveAllState: adding fragment #").append(j2).append(": ").append(g.get(j2)).toString());
                        }
                    }

                    break label0;
                }
            }
            ai = null;
        }
        arraylist = i;
        abackstackstate = null;
        if (arraylist != null)
        {
            k1 = i.size();
            abackstackstate = null;
            if (k1 > 0)
            {
                abackstackstate = new BackStackState[k1];
                for (l1 = 0; l1 < k1; l1++)
                {
                    abackstackstate[l1] = new BackStackState(this, (j)i.get(l1));
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("saveAllState: adding back stack #").append(l1).append(": ").append(i.get(l1)).toString());
                    }
                }

            }
        }
        fragmentmanagerstate = new FragmentManagerState();
        fragmentmanagerstate.a = afragmentstate;
        fragmentmanagerstate.b = ai;
        fragmentmanagerstate.c = abackstackstate;
        return fragmentmanagerstate;
    }

    public void i()
    {
        s = false;
    }

    public void j()
    {
        s = false;
        a(1, false);
    }

    public void k()
    {
        s = false;
        a(2, false);
    }

    public void l()
    {
        s = false;
        a(4, false);
    }

    public void m()
    {
        s = false;
        a(5, false);
    }

    public void n()
    {
        a(4, false);
    }

    public void o()
    {
        s = true;
        a(3, false);
    }

    public void p()
    {
        a(2, false);
    }

    public void q()
    {
        a(1, false);
    }

    public void r()
    {
        t = true;
        e();
        a(0, false);
        o = null;
        p = null;
        q = null;
    }

    public void s()
    {
        if (g != null)
        {
            for (int i1 = 0; i1 < g.size(); i1++)
            {
                Fragment fragment = (Fragment)g.get(i1);
                if (fragment != null)
                {
                    fragment.q();
                }
            }

        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("FragmentManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        if (q != null)
        {
            android.support.v4.b.a.a(q, stringbuilder);
        } else
        {
            android.support.v4.b.a.a(o, stringbuilder);
        }
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

    static 
    {
        int i1 = android.os.Build.VERSION.SDK_INT;
        boolean flag = false;
        if (i1 >= 11)
        {
            flag = true;
        }
        b = flag;
    }
}
