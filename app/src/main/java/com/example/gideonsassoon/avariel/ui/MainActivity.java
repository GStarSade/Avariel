package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Sheet;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import okhttp3.OkHttpClient;

public class MainActivity extends FragmentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    MainFragmentAdaptor mMainFragmentAdaptor;
    Sheet sheet;
    Realm realm;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.et_character_name)
    EditText et_character_name;
    @BindView(R.id.s_race)
    Spinner s_race;
    @BindView(R.id.s_alignment)
    Spinner s_alignment;
    @BindView(R.id.s_class)
    Spinner s_class;
    @BindView(R.id.et_current_hp)
    EditText et_current_hp;
    @BindView(R.id.et_total_hp)
    EditText et_total_hp;
    @BindView(R.id.et_exp)
    EditText et_exp;
    @BindView(R.id.tv_level_value)
    TextView tv_level_value;
    @BindView(R.id.et_strengthScore)
    EditText et_strengthScore;
    @BindView(R.id.et_dexterityScore)
    EditText et_dexterityScore;
    @BindView(R.id.et_constitutionScore)
    EditText et_constitutionScore;
    @BindView(R.id.et_intelligenceScore)
    EditText et_intelligenceScore;
    @BindView(R.id.et_wisdomScore)
    EditText et_wisdomScore;
    @BindView(R.id.et_charismaScore)
    EditText et_charismaScore;
    @BindView(R.id.tv_strength_mod)
    TextView tv_strength_mod;
    @BindView(R.id.tv_dexterity_mod)
    TextView tv_dexterity_mod;
    @BindView(R.id.tv_constitution_mod)
    TextView tv_constitution_mod;
    @BindView(R.id.tv_intelligence_mod)
    TextView tv_intelligence_mod;
    @BindView(R.id.tv_wisdom_mod)
    TextView tv_wisdom_mod;
    @BindView(R.id.tv_charisma_mod)
    TextView tv_charisma_mod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        ButterKnife.bind(this);
        realmInit();

        mMainFragmentAdaptor = new MainFragmentAdaptor(getSupportFragmentManager());
        mViewPager.setAdapter(mMainFragmentAdaptor);
        realm.where(Sheet.class).findAll().addChangeListener(new RealmChangeListener<RealmResults<Sheet>>() {
            @Override
            public void onChange(RealmResults<Sheet> sheets) {
                addPlayerToUI(sheets.first());
            }
        });

        et_character_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange characterName: " + hasFocus);
                if (!hasFocus) {
                    final String name = ((TextView) v).getText().toString();
                    try {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setCharacterName(name);
                            }
                        });
                    } catch (Exception e) {
                        Log.e("REALM SET C NAME ERROR", e.toString());
                    }
                }
            }
        });

        ArrayAdapter<CharSequence> raceAdapter = ArrayAdapter.createFromResource(this, R.array.race, android.R.layout.simple_spinner_dropdown_item);
        s_race.setAdapter(raceAdapter);
        s_race.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, final int position, long id) {
                Log.d(TAG, "onItemSelectedChange race: " + position);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Log.d(TAG, "onItemSelectedChange race execute " + position);
                        sheet.setRace(position);
                    }
                });

                //final String race = ((TextView) v).getText().toString();
                //final SheetEnum.Race raceEnum = SheetEnum.Race.valueOf(race.toUpperCase());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> playerClassAdapter = ArrayAdapter.createFromResource(this, R.array.player_class, android.R.layout.simple_spinner_dropdown_item);
        s_class.setAdapter(playerClassAdapter);
        s_class.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, final int position, long id) {
                Log.d(TAG, "onItemSelectedChange class: " + position);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Log.d(TAG, "onItemSelectedChange class execute " + position);
                        sheet.setPlayerClass(position);
                    }
                });
                //final String race = ((TextView) v).getText().toString();
                //final SheetEnum.Race raceEnum = SheetEnum.Race.valueOf(race.toUpperCase());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<CharSequence> alignmentAdapter = ArrayAdapter.createFromResource(this, R.array.alignment, android.R.layout.simple_spinner_dropdown_item);
        s_alignment.setAdapter(playerClassAdapter);
        s_alignment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, final int position, long id) {
                Log.d(TAG, "onItemSelectedChange class: " + position);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Log.d(TAG, "onItemSelectedChange class execute " + position);
                        sheet.setAlignment(position);
                    }
                });
                //final String race = ((TextView) v).getText().toString();
                //final SheetEnum.Race raceEnum = SheetEnum.Race.valueOf(race.toUpperCase());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

/* Experimental Section */

        et_current_hp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange currentHP: " + hasFocus);
                if (!hasFocus) {
                    final String currentHPString = ((EditText) v).getText().toString();
                    final int currentHP = Integer.parseInt(currentHPString);

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setCurrentHitPoints(currentHP);
                        }
                    });
                }
            }
        });

        et_total_hp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange TOTAL HP: " + hasFocus);
                if (!hasFocus) {
                    final String totalHPString = ((EditText) v).getText().toString();
                    final int totalHP = Integer.parseInt(totalHPString);

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setTotalHitPoints(totalHP);
                        }
                    });
                }
            }
        });

        //TODO LEVEL SET

        et_exp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange EXP: " + hasFocus);
                if (!hasFocus) {
                    final String expString = ((EditText) v).getText().toString();
                    final int exp = Integer.parseInt(expString);

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setExperiencePoint(exp);
                        }
                    });
                    tv_level_value.setText(sheet.getCurrentLevel());
                }
            }
        });

        et_strengthScore.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange Strength: " + hasFocus);
                if (!hasFocus) {
                    final String strengthScoreString = ((EditText) v).getText().toString();
                    final int strengthScore = Integer.parseInt(strengthScoreString);

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setStrengthScore(strengthScore);
                        }
                    });
                    tv_strength_mod.setText(sheet.getStrengthModified());
                }
            }
        });

        et_dexterityScore.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange NAME: " + hasFocus);
                if (!hasFocus) {
                    final String dexterityScoreString = ((EditText) v).getText().toString();
                    final int dexterityScore = Integer.parseInt(dexterityScoreString);

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setDexterityScore(dexterityScore);
                        }
                    });
                    tv_dexterity_mod.setText(sheet.getDexterityModified());
                }
            }
        });

        et_constitutionScore.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange NAME: " + hasFocus);
                if (!hasFocus) {
                    final String constitutionScoreString = ((EditText) v).getText().toString();
                    final int constitutionScore = Integer.parseInt(constitutionScoreString);

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setConstitutionScore(constitutionScore);
                        }
                    });
                    tv_constitution_mod.setText(sheet.getConstitutionModified());
                }
            }
        });

        et_intelligenceScore.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange NAME: " + hasFocus);
                if (!hasFocus) {
                    final String intelligenceScoreString = ((EditText) v).getText().toString();
                    final int intelligenceScore = Integer.parseInt(intelligenceScoreString);

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setIntelligenceScore(intelligenceScore);
                        }
                    });
                    tv_intelligence_mod.setText(sheet.getIntelligenceModified());
                }
            }
        });

        et_wisdomScore.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange NAME: " + hasFocus);
                if (!hasFocus) {
                    final String wisdomScoreString = ((EditText) v).getText().toString();
                    final int wisdomScore = Integer.parseInt(wisdomScoreString);

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setWisdomScore(wisdomScore);
                        }
                    });
                    tv_wisdom_mod.setText(sheet.getWisdomModified());
                }
            }
        });

        et_charismaScore.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange NAME: " + hasFocus);
                if (!hasFocus) {
                    final String charismaScoreString = ((EditText) v).getText().toString();
                    final int charismaScore = Integer.parseInt(charismaScoreString);

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setCharismaScore(charismaScore);
                        }
                    });
                    tv_charisma_mod.setText(sheet.getCharismaModified());
                }
            }
        });

        playerInit();
    }

    private void playerInit() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Log.i("Avariel REALM SET", "Before create object");
                sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();
                if (sheet == null) {
                    sheet = new Sheet();
                    sheet.setSheetID(0);
                    sheet = realm.copyToRealm(sheet);
                }
                Log.i("Avariel REALM SET", "after create object");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        addPlayerToUI(sheet);
                    }
                });
            }
        });
    }

    private void realmInit() {
        /**
         * https://realm.io/docs/java/latest/#getting-started
         * http://facebook.github.io/stetho/
         * https://github.com/uPhyca/stetho-realm
         * chrome://inspect/#devices
         *
         * https://stackoverflow.com/a/36531095/1358857 < Exporting Realm table
         */
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());
        RealmInspectorModulesProvider.builder(this)
                .withFolder(getCacheDir())
                .withMetaTables()
                .withDescendingOrder()
                .withLimit(1000)
                .databaseNamePattern(Pattern.compile(".+\\.realm"))
                .build();
        Stetho.initializeWithDefaults(this);
        Realm.init(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        realm = Realm.getDefaultInstance();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (realm != null) { // guard against weird low-budget phones
            realm.close();
            realm = null;
        }
    }

    //This might in the wrong place by the errors it seems that you're inserting this before it's set up
    void addPlayerToUI(Sheet sheet) {
        et_character_name.setText(sheet.getCharacterName());
        s_race.setSelection(sheet.getRaceInt());
        s_class.setSelection(sheet.getPlayerClassInt());
        s_alignment.setSelection(sheet.getAlignment());
        et_current_hp.setText(String.valueOf(sheet.getCurrentHitPoints()));
        et_total_hp.setText(String.valueOf(sheet.getTotalHitPoints()));
        et_exp.setText(String.valueOf(sheet.getExperiencePoint()));

        et_strengthScore.setText((String.valueOf(sheet.getStrengthScore())));
        et_dexterityScore.setText((String.valueOf(sheet.getDexterityScore())));
        et_constitutionScore.setText((String.valueOf(sheet.getConstitutionScore())));
        et_intelligenceScore.setText((String.valueOf(sheet.getIntelligenceScore())));
        et_wisdomScore.setText((String.valueOf(sheet.getWisdomScore())));
        et_charismaScore.setText((String.valueOf(sheet.getCharismaScore())));

        tv_strength_mod.setText((String.valueOf(sheet.getStrengthModified())));
        tv_dexterity_mod.setText((String.valueOf(sheet.getDexterityModified())));
        tv_constitution_mod.setText((String.valueOf(sheet.getCharismaModified())));
        tv_intelligence_mod.setText((String.valueOf(sheet.getIntelligenceModified())));
        tv_wisdom_mod.setText((String.valueOf(sheet.getWisdomModified())));
        tv_charisma_mod.setText((String.valueOf(sheet.getCharismaModified())));
    }
}