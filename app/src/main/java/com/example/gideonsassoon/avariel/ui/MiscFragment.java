package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Proficiencies;
import com.example.gideonsassoon.avariel.datamodels.Sheet;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Gideon Sassoon on 21/01/2017.
 */

public class MiscFragment extends Fragment {
    private static final String TAG = MiscFragment.class.getSimpleName();
    private Sheet sheet;
    private Realm realm;

    @BindView(R.id.et_personality_trait)
    EditText et_personality_trait;
    @BindView(R.id.et_ideals)
    EditText et_ideals;
    @BindView(R.id.et_bonds)
    EditText et_bonds;
    @BindView(R.id.et_flaws)
    EditText et_flaws;
    @BindView(R.id.et_inspiration)
    EditText et_inspiration;
    @BindView(R.id.et_platinum)
    EditText et_platinum;
    @BindView(R.id.et_gold)
    EditText et_gold;
    @BindView(R.id.et_electrum)
    EditText et_electrum;
    @BindView(R.id.et_silver)
    EditText et_silver;
    @BindView(R.id.et_copper)
    EditText et_copper;
    @BindView(R.id.tv_known_languages)
    TextView tv_known_languages;
    @BindView(R.id.tv_bonus_language_title)
    TextView tv_bonus_language_title;
    @BindView(R.id.s_bonus_language)
    Spinner s_bonus_language;
    @BindView(R.id.et_notes)
    EditText et_notes;
    @BindView(R.id.b_add_proficiencies)
    Button b_add_proficiencies;
    @BindView(R.id.lv_proficiencies_content)
    ListView lv_proficiencies_content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_misc, container, false);
        ButterKnife.bind(this, rootView);
        realm = Realm.getDefaultInstance();
        /* Changed to two lines so that it wont be garbage collected */
        RealmResults<Sheet> sheetResults = realm.where(Sheet.class).findAll();
        sheetResults.addChangeListener(new RealmChangeListener<RealmResults<Sheet>>() {
            @Override
            public void onChange(RealmResults<Sheet> sheets) {
                addPlayerToUI(sheets.first());
            }
        });
        sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();

        et_personality_trait.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange personality trait value: " + hasFocus);
                if (!hasFocus) {
                    final String personalityTrait = ((EditText) v).getText().toString();
                    try {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setPersonalityTraits(personalityTrait);
                            }
                        });
                    } catch (Exception e) {
                        Log.e(TAG,"Realm set PER.TR ERROR "+e.toString());
                    }
                }
            }
        });
        et_ideals.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange ideals value: " + hasFocus);
                if (!hasFocus) {
                    final String ideals = ((EditText) v).getText().toString();
                    try {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setIdeals(ideals);
                            }
                        });
                    } catch (Exception e) {
                        Log.e(TAG,"Realm set IDEALS ERROR "+e.toString());
                    }
                }
            }
        });
        et_bonds.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange bonds value: " + hasFocus);
                if (!hasFocus) {
                    final String bonds = ((EditText) v).getText().toString();
                    try {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setBonds(bonds);
                            }
                        });
                    } catch (Exception e) {
                        Log.e(TAG,"Realm set BONDS ERROR ", e);
                    }
                }
            }
        });
        et_flaws.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange flaws value: " + hasFocus);
                if (!hasFocus) {
                    final String flaws = ((EditText) v).getText().toString();
                    try {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setFlaws(flaws);
                            }
                        });
                    } catch (Exception e) {
                        Log.e(TAG, "Realm set FLAWS ERROR: " , e);
                    }
                }
            }
        });
        et_inspiration.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange inspiration: " + hasFocus);
                if (!hasFocus) {
                    final String inspirationString = ((EditText) v).getText().toString();
                    final int inspiration = Integer.parseInt(inspirationString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setInspiration(inspiration);
                        }
                    });
                }
            }
        });
        et_platinum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange platinum: " + hasFocus);
                if (!hasFocus) {
                    final String platinumString = ((EditText) v).getText().toString();
                    final int platinum = Integer.parseInt(platinumString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setPlatinumCoins(platinum);
                        }
                    });
                }
            }
        });
        et_gold.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange gold: " + hasFocus);
                if (!hasFocus) {
                    final String goldString = ((EditText) v).getText().toString();
                    final int gold = Integer.parseInt(goldString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setGoldCoins(gold);
                        }
                    });
                }
            }
        });
        et_electrum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange electrum: " + hasFocus);
                if (!hasFocus) {
                    final String electrumString = ((EditText) v).getText().toString();
                    final int electrum = Integer.parseInt(electrumString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setElectrumCoins(electrum);
                        }
                    });
                }
            }
        });
        et_silver.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange silver: " + hasFocus);
                if (!hasFocus) {
                    final String silverString = ((EditText) v).getText().toString();
                    final int silver = Integer.parseInt(silverString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setSilverCoins(silver);
                        }
                    });
                }
            }
        });
        et_copper.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange copper: " + hasFocus);
                if (!hasFocus) {
                    final String copperString = ((TextView) v).getText().toString();
                    final int copper = Integer.parseInt(copperString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setCopperCoins(copper);
                        }
                    });
                }
            }
        });
        ArrayAdapter<CharSequence> bonusLanguageAdapter = ArrayAdapter.createFromResource(getContext(), R.array.language, android.R.layout.simple_spinner_dropdown_item);
        s_bonus_language.setAdapter(bonusLanguageAdapter);
        //
        s_bonus_language.setSelection(sheet.getBonusLanguage());
        s_bonus_language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                if (position != sheet.getBonusLanguage())
                    Log.d(TAG, "onItemSelectedChange language: " + position);
                final String[] value = getContext().getResources().getStringArray(R.array.language);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Log.d(TAG, "onItemSelectedChange language: " + position + " value: " + value[position]);
                        sheet.setBonusLanguage(position);
                    }
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        et_notes.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange notes: " + hasFocus);
                if (!hasFocus) {
                    final String notes = ((EditText) v).getText().toString();
                    try {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setNotes(notes);
                            }
                        });
                    } catch (Exception e) {
                        Log.e(TAG, "Realm set FLAWS ERROR: " , e);
                    }
                }
            }
        });

        b_add_proficiencies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newBlankSheetProficiencies();
            }
        });

        RealmList<Proficiencies> proficienciesList = sheet.getProficienciesList();
        final ProficienciesListViewContentAdapter proficienciesListViewContentAdapter = new ProficienciesListViewContentAdapter(getActivity(), realm, proficienciesList);
        proficienciesList.addChangeListener(new RealmChangeListener<RealmList<Proficiencies>>() {
            @Override
            public void onChange(RealmList<Proficiencies> proficiencies) {
                proficienciesListViewContentAdapter.notifyDataSetChanged();
            }
        });
        lv_proficiencies_content.setAdapter(proficienciesListViewContentAdapter);
        return rootView;
    }

    private void newBlankSheetProficiencies() {
        Log.d(TAG, "newBlankSheetProficiencies: START");
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number maxValue = realm.where(Proficiencies.class).max("proficienciesID");
                int maxValueInt;
                if (maxValue != null) {
                    maxValueInt = maxValue.intValue();
                    maxValueInt = maxValueInt + 1;
                } else maxValueInt = 0;
                try {
                    Log.d(TAG, "newBlankSheetProficiencies: ");
                    sheet.getProficienciesList().add(realm.createObject(Proficiencies.class, maxValueInt));
                } catch (Exception e) {
                    Log.e(TAG, "newBlankSheetProficiencies: maxValue: " + maxValue + " maxValueInt: " + String.valueOf(maxValueInt) , e);
                }
            }
        });
    }

    void addPlayerToUI(Sheet sheet) {
        et_personality_trait.setText(sheet.getPersonalityTraits());
        et_ideals.setText(sheet.getIdeals());
        et_bonds.setText(sheet.getBonds());
        et_flaws.setText(sheet.getFlaws());
        et_inspiration.setText(String.valueOf(sheet.getInspiration()));
        et_platinum.setText(String.valueOf(sheet.getPlatinumCoins()));
        et_gold.setText(String.valueOf(sheet.getGoldCoins()));
        et_electrum.setText(String.valueOf(sheet.getElectrumCoins()));
        et_silver.setText(String.valueOf(sheet.getSilverCoins()));
        et_copper.setText(String.valueOf(sheet.getCopperCoins()));
        et_notes.setText(sheet.getNotes());
        visibilityCheck();
        tv_known_languages.setText(sheet.getRaceLanguageAsReadableString().toString());
    }

    private void visibilityCheck() {
        if (sheet.isRaceBonusLanguage()) {
            tv_bonus_language_title.setVisibility(View.VISIBLE);
            s_bonus_language.setVisibility(View.VISIBLE);
        } else {
            tv_bonus_language_title.setVisibility(View.INVISIBLE);
            s_bonus_language.setVisibility(View.INVISIBLE);
        }
    }
}
