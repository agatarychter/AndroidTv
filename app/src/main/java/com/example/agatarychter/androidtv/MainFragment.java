package com.example.agatarychter.androidtv;
import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;


public class MainFragment extends BrowseFragment {

    private ArrayObjectAdapter mRowsAdapter;
    private static SimpleBackgroundManager simpleBackgroundManager = null;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupUIElements();
        loadRows();
        setupEventListeners();
        simpleBackgroundManager = new SimpleBackgroundManager(getActivity());

    }

    private void setupEventListeners() {
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item,
                                   RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof String) {
                simpleBackgroundManager.clearBackground();
            } else if (item instanceof Photo) {
                simpleBackgroundManager.updateBackground(MainActivity.context.getDrawable(((Photo) item).getImage()));
            }

        }
    }
    private void setupUIElements() {
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(getResources().getColor(R.color.fastlane_background));
        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));
        setHeaderPresenterSelector(new PresenterSelector() {
            @Override
            public Presenter getPresenter(Object o) {
                return new IconHeaderItemPresenter();
            }
        });
    }


    private void loadRows() {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        HeaderItem gridItemPresenterHeader = new Model(0, MainActivity.context.getString(R.string.meals),R.drawable.meals);
        HeaderItem gridItemPresenterHeader1 = new Model(1, MainActivity.context.getString(R.string.sweets),R.drawable.sweets);
        HeaderItem gridItemPresenterHeader2 = new Model(2, MainActivity.context.getString(R.string.drinks),R.drawable.drinks);

        CardPresenter cardPresenter = new CardPresenter();
        ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);
        ArrayObjectAdapter cardRowAdapter1 = new ArrayObjectAdapter(cardPresenter);
        ArrayObjectAdapter cardRowAdapter2 = new ArrayObjectAdapter(cardPresenter);

        setMeals(cardRowAdapter);
        setSweets(cardRowAdapter1);
        setDrinks(cardRowAdapter2);

        mRowsAdapter.add(new ListRow(gridItemPresenterHeader, cardRowAdapter));
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader1,cardRowAdapter1));
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader2, cardRowAdapter2));
        setAdapter(mRowsAdapter);
    }

    public void setMeals(ArrayObjectAdapter arrayObjectAdapter) {
        Photo photo = new Photo( MainActivity.context.getString(R.string.pizza),R.drawable.pizza);
        photo.setTitle(photo.getTitle());
        Photo photo1 = new Photo(MainActivity.context.getString(R.string.shrimps),R.drawable.shrimps);
        photo1.setTitle(photo1.getTitle());
        Photo photo2 = new Photo(MainActivity.context.getString(R.string.dims),R.drawable.dim);
        photo2.setTitle(photo2.getTitle());
        arrayObjectAdapter.add(photo);
        arrayObjectAdapter.add(photo1);
        arrayObjectAdapter.add(photo2);
    }

    public void setSweets(ArrayObjectAdapter arrayObjectAdapter) {
        Photo photo = new Photo(MainActivity.context.getString(R.string.muffins),R.drawable.muffins);
        photo.setTitle(photo.getTitle());
        Photo photo1 = new Photo(MainActivity.context.getString(R.string.monkey),R.drawable.monkey);
        photo1.setTitle(photo1.getTitle());
        Photo photo2 = new Photo(MainActivity.context.getString(R.string.briga),R.drawable.brigadeiro);
        photo2.setTitle(photo2.getTitle());
        arrayObjectAdapter.add(photo);
        arrayObjectAdapter.add(photo1);
        arrayObjectAdapter.add(photo2);
    }
    public void setDrinks(ArrayObjectAdapter arrayObjectAdapter) {
        Photo photo = new Photo(MainActivity.context.getString(R.string.hot),R.drawable.hotchoco);
        photo.setTitle(photo.getTitle());
        Photo photo1 = new Photo(MainActivity.context.getString(R.string.shake),R.drawable.shake);
        photo1.setTitle(photo.getTitle());
        Photo photo2 = new Photo(MainActivity.context.getString(R.string.lemon),R.drawable.lemon);
        photo2.setTitle(photo2.getTitle());
        arrayObjectAdapter.add(photo);
        arrayObjectAdapter.add(photo1);
        arrayObjectAdapter.add(photo2);
    }

}