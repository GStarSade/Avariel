package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Sheet;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by Gideon Sassoon on 21/01/2017.
 */

public class AdventureFragment extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Realm realm;
    private Sheet sheet;

    @BindView(R.id.cb_acrobatics)
    CheckBox cb_acrobatics;
    @BindView(R.id.et_acrobatics)
    EditText et_acrobatics;

    @BindView(R.id.cb_animal_handling)
    CheckBox cb_animal_handling;
    @BindView(R.id.et_animal_handling)
    EditText et_animal_handling;

    @BindView(R.id.cb_arcana)
    CheckBox cb_arcana;
    @BindView(R.id.et_arcana)
    EditText et_arcana;

    @BindView(R.id.cb_athletics)
    CheckBox cb_athletics;
    @BindView(R.id.et_athletics)
    EditText et_athletics;

    @BindView(R.id.cb_deception)
    CheckBox cb_deception;
    @BindView(R.id.et_deception)
    EditText et_deception;

    @BindView(R.id.cb_history)
    CheckBox cb_history;
    @BindView(R.id.et_history)
    EditText et_history;

    @BindView(R.id.cb_insight)
    CheckBox cb_insight;
    @BindView(R.id.et_insight)
    EditText et_insight;

    @BindView(R.id.cb_intimidation)
    CheckBox cb_intimidation;
    @BindView(R.id.et_intimidation)
    EditText et_intimidation;

    @BindView(R.id.cb_investigation)
    CheckBox cb_investigation;
    @BindView(R.id.et_investigation)
    EditText et_investigation;

    @BindView(R.id.cb_medicine)
    CheckBox cb_medicine;
    @BindView(R.id.et_medicine)
    EditText et_medicine;

    @BindView(R.id.cb_nature)
    CheckBox cb_nature;
    @BindView(R.id.et_nature)
    EditText et_nature;

    @BindView(R.id.cb_perception)
    CheckBox cb_perception;
    @BindView(R.id.et_perception)
    EditText et_perception;

    @BindView(R.id.cb_performance)
    CheckBox cb_performance;
    @BindView(R.id.et_performance)
    EditText et_performance;

    @BindView(R.id.cb_persuasion)
    CheckBox cb_persuasion;
    @BindView(R.id.et_persuasion)
    EditText et_persuasion;

    @BindView(R.id.cb_religion)
    CheckBox cb_religion;
    @BindView(R.id.et_religion)
    EditText et_religion;

    @BindView(R.id.cb_sleight_of_hand)
    CheckBox cb_sleight_of_hand;
    @BindView(R.id.et_sleight_of_hand)
    EditText et_sleight_of_hand;

    @BindView(R.id.cb_stealth)
    CheckBox cb_stealth;
    @BindView(R.id.et_stealth)
    EditText et_stealth;

    @BindView(R.id.cb_survival)
    CheckBox cb_survival;
    @BindView(R.id.et_survival)
    EditText et_survival;

    @BindView(R.id.b_add_equipment)
    Button b_add_equipment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_adventure, container, false);
        ButterKnife.bind(this, rootView);
        realm = Realm.getDefaultInstance();
        realm.where(Sheet.class).findAll().addChangeListener(new RealmChangeListener<RealmResults<Sheet>>() {
            @Override
            public void onChange(RealmResults<Sheet> sheets) {
                addPlayerToUI(sheets.first());
            }
        });
        sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();

        cb_acrobatics.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange acrobatics: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setAcrobaticsProficiency(isChecked);
                    }
                });
            }
        });

        et_acrobatics.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange acrobatics: " + hasFocus);
                if (!hasFocus) {
                    final String acrobaticsString = ((EditText) v).getText().toString();
                    final int acrobatics = Integer.parseInt(acrobaticsString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setAcrobaticsProficiencyInt(acrobatics);
                        }
                    });
                }
            }
        });

        cb_animal_handling.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange animalHandling: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setAnimalHealingProficiency(isChecked);
                    }
                });
            }
        });

        et_animal_handling.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange animalHandling: " + hasFocus);
                if (!hasFocus) {
                    final String animalHandlingString = ((EditText) v).getText().toString();
                    final int animalHandling = Integer.parseInt(animalHandlingString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setAnimalHealingProficiencyInt(animalHandling);
                        }
                    });
                }
            }
        });


        cb_arcana.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange arcana: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setArcanaProficiency(isChecked);
                    }
                });
            }
        });

        et_arcana.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange arcana: " + hasFocus);
                if (!hasFocus) {
                    final String arcanaString = ((EditText) v).getText().toString();
                    final int arcana = Integer.parseInt(arcanaString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setArcanaProficiencyInt(arcana);
                        }
                    });
                }
            }
        });

        cb_athletics.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange athletics: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setAthleticsProficiency(isChecked);
                    }
                });
            }
        });

        et_athletics.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange athletics: " + hasFocus);
                if (!hasFocus) {
                    final String athleticsString = ((EditText) v).getText().toString();
                    final int athletics = Integer.parseInt(athleticsString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setAthleticsProficiencyInt(athletics);
                        }
                    });
                }
            }
        });

        cb_deception.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange deception: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setDeceptionProficiency(isChecked);
                    }
                });
            }
        });

        et_deception.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange deception: " + hasFocus);
                if (!hasFocus) {
                    final String deceptionString = ((EditText) v).getText().toString();
                    final int deception = Integer.parseInt(deceptionString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setDeceptionProficiencyInt(deception);
                        }
                    });
                }
            }
        });

        cb_history.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange history: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setHistoryProficiency(isChecked);
                    }
                });
            }
        });

        et_history.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange history: " + hasFocus);
                if (!hasFocus) {
                    final String historyString = ((EditText) v).getText().toString();
                    final int history = Integer.parseInt(historyString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setHistoryProficiencyInt(history);
                        }
                    });
                }
            }
        });

        cb_insight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange insight: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setInsightProficiency(isChecked);
                    }
                });
            }
        });

        et_insight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange insight: " + hasFocus);
                if (!hasFocus) {
                    final String insightString = ((EditText) v).getText().toString();
                    final int insight = Integer.parseInt(insightString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setInsightProficiencyInt(insight);
                        }
                    });
                }
            }
        });

        cb_intimidation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange intimidation: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setIntimidationProficiency(isChecked);
                    }
                });
            }
        });

        et_intimidation.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange intimidation: " + hasFocus);
                if (!hasFocus) {
                    final String intimidationString = ((EditText) v).getText().toString();
                    final int intimidation = Integer.parseInt(intimidationString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setIntimidationProficiencyInt(intimidation);
                        }
                    });
                }
            }
        });

        cb_investigation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange investigation: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setInvestigationProficiency(isChecked);
                    }
                });
            }
        });

        et_investigation.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange investigation: " + hasFocus);
                if (!hasFocus) {
                    final String investigationString = ((EditText) v).getText().toString();
                    final int investigation = Integer.parseInt(investigationString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setInvestigationProficiencyInt(investigation);
                        }
                    });
                }
            }
        });

        cb_medicine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange medicine: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setMedicineProficiency(isChecked);
                    }
                });
            }
        });

        et_medicine.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange medicine: " + hasFocus);
                if (!hasFocus) {
                    final String medicineString = ((EditText) v).getText().toString();
                    final int medicine = Integer.parseInt(medicineString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setMedicineProficiencyInt(medicine);
                        }
                    });
                }
            }
        });

        cb_nature.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange nature: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setNatureProficiency(isChecked);
                    }
                });
            }
        });

        et_nature.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange nature: " + hasFocus);
                if (!hasFocus) {
                    final String natureString = ((EditText) v).getText().toString();
                    final int nature = Integer.parseInt(natureString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setNatureProficiencyInt(nature);
                        }
                    });
                }
            }
        });

        cb_perception.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange perception: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setPerceptionProficiency(isChecked);
                    }
                });
            }
        });

        et_perception.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange perception: " + hasFocus);
                if (!hasFocus) {
                    final String perceptionString = ((EditText) v).getText().toString();
                    final int perception = Integer.parseInt(perceptionString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setPerceptionProficiencyInt(perception);
                        }
                    });
                }
            }
        });

        cb_performance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange performance: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setPerformanceProficiency(isChecked);
                    }
                });
            }
        });

        et_performance.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange performance: " + hasFocus);
                if (!hasFocus) {
                    final String performanceString = ((EditText) v).getText().toString();
                    final int performance = Integer.parseInt(performanceString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setPerformanceProficiencyInt(performance);
                        }
                    });
                }
            }
        });

        cb_persuasion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange persuasion: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setPersuasionProficiency(isChecked);
                    }
                });
            }
        });

        et_persuasion.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange persuasion: " + hasFocus);
                if (!hasFocus) {
                    final String persuasionString = ((EditText) v).getText().toString();
                    final int persuasion = Integer.parseInt(persuasionString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setPersuasionProficiencyInt(persuasion);
                        }
                    });
                }
            }
        });

        cb_religion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange religion: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setReligionProficiency(isChecked);
                    }
                });
            }
        });

        et_religion.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange religion: " + hasFocus);
                if (!hasFocus) {
                    final String religionString = ((EditText) v).getText().toString();
                    final int religion = Integer.parseInt(religionString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setReligionProficiencyInt(religion);
                        }
                    });
                }
            }
        });

        cb_sleight_of_hand.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange sleightOfHand: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setSleightOfHandProficiency(isChecked);
                    }
                });
            }
        });

        et_sleight_of_hand.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange sleightOfHand: " + hasFocus);
                if (!hasFocus) {
                    final String sleightOfHandString = ((EditText) v).getText().toString();
                    final int sleightOfHand = Integer.parseInt(sleightOfHandString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setSleightOfHandProficiencyInt(sleightOfHand);
                        }
                    });
                }
            }
        });

        cb_stealth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange stealth: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setStealthProficiency(isChecked);
                    }
                });
            }
        });

        et_stealth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange stealth: " + hasFocus);
                if (!hasFocus) {
                    final String stealthString = ((EditText) v).getText().toString();
                    final int stealth = Integer.parseInt(stealthString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setStealthProficiencyInt(stealth);
                        }
                    });
                }
            }
        });

        cb_survival.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                Log.d(TAG, "onCheckedChange survival: " + isChecked);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        sheet.setSurvivalProficiency(isChecked);
                    }
                });
            }
        });

        et_survival.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange survival: " + hasFocus);
                if (!hasFocus) {
                    final String survivalString = ((EditText) v).getText().toString();
                    final int survival = Integer.parseInt(survivalString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setSurvivalProficiencyInt(survival);
                        }
                    });
                }
            }
        });

        return rootView;
    }

    void addPlayerToUI(Sheet sheet) {
        cb_acrobatics.setChecked(sheet.isAcrobaticsProficiency());
        et_acrobatics.setText(String.valueOf(sheet.getAcrobaticsProficiencyInt()));

        cb_animal_handling.setChecked(sheet.isAnimalHealingProficiency());
        et_animal_handling.setText(String.valueOf(sheet.getAnimalHealingProficiencyInt()));

        cb_arcana.setChecked(sheet.isArcanaProficiency());
        et_arcana.setText(String.valueOf(sheet.getArcanaProficiencyInt()));

        cb_athletics.setChecked(sheet.isAthleticsProficiency());
        et_athletics.setText(String.valueOf(sheet.getAthleticsProficiencyInt()));

        cb_deception.setChecked(sheet.isDeceptionProficiency());
        et_deception.setText(String.valueOf(sheet.getDeceptionProficiencyInt()));

        cb_history.setChecked(sheet.isHistoryProficiency());
        et_history.setText(String.valueOf(sheet.getHistoryProficiencyInt()));

        cb_insight.setChecked(sheet.isInsightProficiency());
        et_insight.setText(String.valueOf(sheet.getInsightProficiencyInt()));

        cb_intimidation.setChecked(sheet.isIntimidationProficiency());
        et_intimidation.setText(String.valueOf(sheet.getIntimidationProficiencyInt()));

        cb_investigation.setChecked(sheet.isInvestigationProficiency());
        et_investigation.setText(String.valueOf(sheet.getInvestigationProficiencyInt()));

        cb_medicine.setChecked(sheet.isMedicineProficiency());
        et_medicine.setText(String.valueOf(sheet.getMedicineProficiencyInt()));

        cb_nature.setChecked(sheet.isNatureProficiency());
        et_nature.setText(String.valueOf(sheet.getNatureProficiencyInt()));

        cb_perception.setChecked(sheet.isPerceptionProficiency());
        et_perception.setText(String.valueOf(sheet.getPerceptionProficiencyInt()));

        cb_performance.setChecked(sheet.isPerformanceProficiency());
        et_performance.setText(String.valueOf(sheet.getPerformanceProficiencyInt()));

        cb_persuasion.setChecked(sheet.isPersuasionProficiency());
        et_persuasion.setText(String.valueOf(sheet.getPersuasionProficiencyInt()));

        cb_religion.setChecked(sheet.isReligionProficiency());
        et_religion.setText(String.valueOf(sheet.getReligionProficiencyInt()));

        cb_sleight_of_hand.setChecked(sheet.isSleightOfHandProficiency());
        et_sleight_of_hand.setText(String.valueOf(sheet.getSleightOfHandProficiencyInt()));

        cb_stealth.setChecked(sheet.isStealthProficiency());
        et_stealth.setText(String.valueOf(sheet.getStealthProficiencyInt()));

        cb_survival.setChecked(sheet.isSurvivalProficiency());
        et_survival.setText(String.valueOf(sheet.getSurvivalProficiencyInt()));
    }
}
