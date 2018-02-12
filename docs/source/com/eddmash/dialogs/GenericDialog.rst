.. java:import:: android.os Bundle

.. java:import:: android.support.annotation ColorRes

.. java:import:: android.support.annotation DrawableRes

.. java:import:: android.support.annotation LayoutRes

.. java:import:: android.support.annotation Nullable

.. java:import:: android.support.v4.app DialogFragment

.. java:import:: android.support.v4.content ContextCompat

.. java:import:: android.view LayoutInflater

.. java:import:: android.view View

.. java:import:: android.view ViewGroup

.. java:import:: android.view Window

.. java:import:: android.view WindowManager

.. java:import:: android.widget Button

.. java:import:: android.widget ImageView

.. java:import:: android.widget LinearLayout

.. java:import:: android.widget TextView

.. java:import:: java.util HashMap

.. java:import:: java.util Map

GenericDialog
=============

.. java:package:: com.eddmash.dialogs
   :noindex:

.. java:type:: public abstract class GenericDialog extends DialogFragment

   A generic class that makes it easy to customize dialog boxes. example usage of an implementation \ :java:ref:`AlertboxDialog`\

   .. parsed-literal::

      AlertboxDialog alertboxDialog = new AlertboxDialog();
      alertboxDialog.disableButtons(true);
      alertboxDialog.setTitle("NETWORK ERROR");
      alertboxDialog.setIcon(R.drawable.fail);
      alertboxDialog.setMessage(activity.getString(R.string.network_error));
      alertboxDialog.show(activity.getSupportFragmentManager(), "network_error");

Fields
------
layout
^^^^^^

.. java:field:: protected View layout
   :outertype: GenericDialog

leftButton
^^^^^^^^^^

.. java:field:: protected Button leftButton
   :outertype: GenericDialog

rightButton
^^^^^^^^^^^

.. java:field:: protected Button rightButton
   :outertype: GenericDialog

Constructors
------------
GenericDialog
^^^^^^^^^^^^^

.. java:constructor:: public GenericDialog()
   :outertype: GenericDialog

Methods
-------
disableButtons
^^^^^^^^^^^^^^

.. java:method:: public void disableButtons(boolean b)
   :outertype: GenericDialog

getContentLayout
^^^^^^^^^^^^^^^^

.. java:method:: protected int getContentLayout()
   :outertype: GenericDialog

onCreateView
^^^^^^^^^^^^

.. java:method:: @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
   :outertype: GenericDialog

onViewCreated
^^^^^^^^^^^^^

.. java:method:: @Override public void onViewCreated(View view, Bundle savedInstanceState)
   :outertype: GenericDialog

onViewReady
^^^^^^^^^^^

.. java:method:: protected abstract void onViewReady(View view, Bundle savedInstanceState)
   :outertype: GenericDialog

   Add your logic to this method since at this point most of the work is done for you and the base layout has been polutated with your content layout

setContentLayout
^^^^^^^^^^^^^^^^

.. java:method:: public void setContentLayout(int layoutID)
   :outertype: GenericDialog

setIcon
^^^^^^^

.. java:method:: public void setIcon(int drawable)
   :outertype: GenericDialog

setLeftButton
^^^^^^^^^^^^^

.. java:method:: public void setLeftButton(String label, ButtonClickedListener clickListener)
   :outertype: GenericDialog

   SEt the listner to be invoked when the left button is clicked

   :param label:
   :param clickListener:

setRightButton
^^^^^^^^^^^^^^

.. java:method:: public void setRightButton(String label, ButtonClickedListener clickListener)
   :outertype: GenericDialog

   set listener to be invoked when the right button is cliked.

   :param label:
   :param clickListener:

setTitle
^^^^^^^^

.. java:method:: public void setTitle(String title)
   :outertype: GenericDialog

setTitleBackground
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setTitleBackground(int titleBgColor)
   :outertype: GenericDialog

setTitleTextColor
^^^^^^^^^^^^^^^^^

.. java:method:: public void setTitleTextColor(int titleBgColor)
   :outertype: GenericDialog

