.. Android Components documentation master file, created by
   sphinx-quickstart on Thu Feb  8 08:15:01 2018.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

Welcome to Android Components's documentation!
==============================================

.. toctree::
   :maxdepth: 1
   :caption: Contents:

Documentation for android components

To be able to use any of this components.

- Add the JitPack repository to your build file

.. code-block:: java

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

- Add the dependency you would like

.. code-block:: java

	dependencies {
	        compile 'com.github.eddmash.androidcomponents:activerecord:2.0.1'
	        compile 'com.github.eddmash:androidcomponents:grid:2.0.1'
	        compile 'com.github.eddmash:androidcomponents:form:2.0.1'
	        compile 'com.github.eddmash:androidcomponents:validation:2.0.1'
	        compile 'com.github.eddmash:androidcomponents:pagination:2.0.1'
	        compile 'com.github.eddmash:androidcomponents:adapter:2.0.1'
	        compile 'com.github.eddmash:androidcomponents:views:2.0.1'
	}

.. toctree::
   :maxdepth: 1

   Validation Documentation <validation/index>
   Form Documentation <form/index>
   Pagination Documentation <pagination/index>
   Grid Documentation <grid/index>
   Components Api <packages>

Indices and tables
==================

* :ref:`genindex`
* :ref:`modindex`
* :ref:`search`
